package com.example.calculadoraimc.domain.model

import com.example.calculadoraimc.domain.ClassificacaoImc

data class CalculoImc(
    val id: Long = 0,
    val peso: Double,
    val altura: Double,
    val imc: Double,
    val classificacao: ClassificacaoImc,
    val dataHora: Long
)