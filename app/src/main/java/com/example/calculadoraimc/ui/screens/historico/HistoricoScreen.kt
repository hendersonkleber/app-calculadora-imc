package com.example.calculadoraimc.ui.screens.historico

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.calculadoraimc.domain.model.CalculoImc
import com.example.calculadoraimc.ui.common.texto
import com.example.calculadoraimc.ui.theme.CalculadoraimcTheme

@Composable
fun HistoricoScreen(
    onVoltarClick: () -> Unit,
    viewModel: HistoricoViewModel
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    HistoricoContent(
        state = state,
        onVoltarClick = onVoltarClick,
    )
}

@Composable
private fun HistoricoContent(
    state: HistoricoUiState,
    onVoltarClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Histórico",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        if (state.calculos.isEmpty()) {
            Text(
                text = "Nenhum cálculo realizado."
            )
        } else {
            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = state.calculos,
                    key = { calculo -> calculo.id }
                ) { calculo ->
                    HistoricoItem(calculo)
                }
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button (
            onClick = onVoltarClick
        ) {
            Text("Voltar")
        }
    }
}

@Composable
private fun HistoricoItem(
    calculo: CalculoImc
) {
    Card (
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "IMC: %.2f".format(calculo.imc),
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "Peso: %.2f kg".format(calculo.peso)
            )

            Text(
                text = "Altura: %.2f m".format(calculo.altura)
            )

            Text(
                text = "Classificação: ${calculo.classificacao.texto()}"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HistoricoScreenPreview() {
    CalculadoraimcTheme() {
        HistoricoContent (
            onVoltarClick = {},
            state = HistoricoUiState()
        )
    }
}