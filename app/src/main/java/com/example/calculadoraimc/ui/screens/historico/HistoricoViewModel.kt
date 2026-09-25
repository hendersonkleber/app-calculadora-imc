package com.example.calculadoraimc.ui.screens.historico

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculadoraimc.domain.repository.CalculoImcRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HistoricoViewModel @Inject constructor(
    repository: CalculoImcRepository
) : ViewModel() {

    val state = repository
        .obter()
        .map { calculos ->
            HistoricoUiState(
                calculos = calculos
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = HistoricoUiState()
        )
}