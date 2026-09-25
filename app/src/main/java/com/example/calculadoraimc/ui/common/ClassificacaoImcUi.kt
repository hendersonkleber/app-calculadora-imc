package com.example.calculadoraimc.ui.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.calculadoraimc.R
import com.example.calculadoraimc.domain.ClassificacaoImc

@Composable
fun ClassificacaoImc.texto(): String {
    return when (this) {
        ClassificacaoImc.ABAIXO_DO_PESO ->
            stringResource(R.string.classificacao_abaixo_peso)

        ClassificacaoImc.NORMAL ->
            stringResource(R.string.classificacao_normal)

        ClassificacaoImc.SOBREPESO ->
            stringResource(R.string.classificacao_sobrepeso)

        ClassificacaoImc.OBESIDADE_GRAU_I ->
            stringResource(R.string.classificacao_obesidade_grau_1)

        ClassificacaoImc.OBESIDADE_GRAU_II ->
            stringResource(R.string.classificacao_obesidade_grau_2)

        ClassificacaoImc.OBESIDADE_GRAU_III ->
            stringResource(R.string.classificacao_obesidade_grau_3)
    }
}