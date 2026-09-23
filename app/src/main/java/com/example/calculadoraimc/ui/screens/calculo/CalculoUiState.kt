package com.example.calculadoraimc.ui.screens.calculo

import com.example.calculadoraimc.domain.ClassificacaoImc

data class CalculoUiState(
    val peso: String = "",
    val altura: String = "",
    val imc: Double? = null,
    val classificacao: ClassificacaoImc? = null,
    val pesoInvalido: Boolean = false,
    val alturaInvalida: Boolean = false
)