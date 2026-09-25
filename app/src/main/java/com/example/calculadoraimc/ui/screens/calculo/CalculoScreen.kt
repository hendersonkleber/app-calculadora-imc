package com.example.calculadoraimc.ui.screens.calculo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadoraimc.R
import com.example.calculadoraimc.domain.ClassificacaoImc
import com.example.calculadoraimc.ui.common.texto
import com.example.calculadoraimc.ui.theme.CalculadoraimcTheme

@Composable
fun CalculoScreen(
    onHistoricoClick: () -> Unit,
    viewModel: CalculoViewModel
) {
    CalculoContent(
        state = viewModel.state,
        onPesoChange = viewModel::onPesoChange,
        onAlturaChange = viewModel::onAlturaChange,
        onCalcularClick = viewModel::calcular,
        onHistoricoClick = onHistoricoClick
    )
}

@Composable
fun CalculoContent(
    state: CalculoUiState,
    onPesoChange: (String) -> Unit,
    onAlturaChange: (String) -> Unit,
    onCalcularClick: () -> Unit,
    onHistoricoClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Calculadora de IMC",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = state.peso,
            onValueChange = {
                if (it.matches(Regex("""^\d*[.,]?\d*$"""))) {
                    onPesoChange(it);
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Peso (KG)")
            },
            isError = state.pesoInvalido,
            supportingText = {
                if (state.pesoInvalido) {
                    Text("Informe um peso válido")
                }
            }
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(
            value = state.altura,
            onValueChange = {
                if (it.matches(Regex("""^\d*[.,]?\d*$"""))) {
                    onAlturaChange(it);
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Altura (m)")
            },
            isError = state.alturaInvalida,
            supportingText = {
                if (state.alturaInvalida) {
                    Text("Informe uma altura válida")
                }
            }
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = onCalcularClick,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Calcular")
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        FilledTonalButton(
            onClick = onHistoricoClick,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(text = "Histórico")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = state.imc?.let {
                "IMC: %.2f".format(state.imc)
            } ?: "IMC: --"
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = state.classificacao?.let {
                "Classificação: ${it.texto()}"
            } ?: "Classificação: --"
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun CalculoContentPreview() {
    CalculadoraimcTheme {
        CalculoContent(
            state = CalculoUiState(
                peso = "80",
                altura = "1,80",
                imc = 24.69,
                classificacao = ClassificacaoImc.NORMAL
            ),
            onPesoChange = {},
            onAlturaChange = {},
            onCalcularClick = {},
            onHistoricoClick = {}
        )
    }
}