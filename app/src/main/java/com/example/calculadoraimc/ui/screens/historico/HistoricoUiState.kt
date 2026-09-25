package com.example.calculadoraimc.ui.screens.historico

import com.example.calculadoraimc.domain.model.CalculoImc

data class HistoricoUiState(
    val calculos: List<CalculoImc> = emptyList()
)