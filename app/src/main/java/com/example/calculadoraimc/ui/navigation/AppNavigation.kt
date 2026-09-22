package com.example.calculadoraimc.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.calculadoraimc.ui.screens.calculo.CalculoScreen
import com.example.calculadoraimc.ui.screens.historico.HistoricoScreen

@Composable
fun AppNavigation() {
    val backStack = rememberNavBackStack(Calculo)

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<Calculo> {
                CalculoScreen()
            }

            entry<Historico> {
                HistoricoScreen()
            }
        }
    )
}