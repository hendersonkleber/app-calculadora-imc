package com.example.calculadoraimc.domain

fun classificarImc(imc: Double): ClassificacaoImc {
    return when {
        imc < 18.5 -> ClassificacaoImc.ABAIXO_DO_PESO
        imc < 25 -> ClassificacaoImc.NORMAL
        imc < 30 -> ClassificacaoImc.SOBREPESO
        imc < 35 -> ClassificacaoImc.OBESIDADE_GRAU_I
        imc < 40 -> ClassificacaoImc.OBESIDADE_GRAU_II
        else -> ClassificacaoImc.OBESIDADE_GRAU_III
    }
}