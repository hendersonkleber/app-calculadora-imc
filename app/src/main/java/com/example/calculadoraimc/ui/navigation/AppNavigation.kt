package com.example.calculadoraimc.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.calculadoraimc.ui.screens.calculo.CalculoScreen
import com.example.calculadoraimc.ui.screens.calculo.CalculoViewModel
import com.example.calculadoraimc.ui.screens.historico.HistoricoScreen

@Composable
fun AppNavigation() {
    val backStack = rememberNavBackStack(Calculo)

    NavDisplay(
        backStack = backStack,

        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),

        entryProvider = entryProvider {
            entry<Calculo> {
                val viewModel: CalculoViewModel = hiltViewModel()

                CalculoScreen(
                    viewModel = viewModel,
                    onHistoricoClick = {
                        backStack.add(Historico)
                    }
                )
            }

            entry<Historico> {
                HistoricoScreen(
                    onVoltarClick = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        }
    )
}
