package com.example.calculadoraimc.ui.screens.calculo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadoraimc.ui.theme.CalculadoraimcTheme

@Composable
fun CalculoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Calculadora de IMC"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Peso (KG)")
            }
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Altura (m)")
            }
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Calcular")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text("IMC: --")

        Spacer(modifier = Modifier.height(8.dp))

        Text("Classificação: --")
    }
}

@Preview(showBackground = true)
@Composable
fun CalculoScreenPreview() {
    CalculadoraimcTheme() {
        CalculoScreen()
    }
}