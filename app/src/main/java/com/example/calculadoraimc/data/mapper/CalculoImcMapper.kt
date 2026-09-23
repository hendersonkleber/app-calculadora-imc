package com.example.calculadoraimc.data.mapper

import com.example.calculadoraimc.data.local.entity.CalculoImcEntity
import com.example.calculadoraimc.domain.ClassificacaoImc
import com.example.calculadoraimc.domain.model.CalculoImc

fun CalculoImc.toEntity(): CalculoImcEntity {
    return CalculoImcEntity(
        id = id,
        peso = peso,
        altura = altura,
        imc = imc,
        classificacao = classificacao.name,
        dataHora = dataHora
    )
}

fun CalculoImcEntity.toDomain(): CalculoImc {
    return CalculoImc(
        id = id,
        peso = peso,
        altura = altura,
        imc = imc,
        classificacao = ClassificacaoImc.valueOf(classificacao),
        dataHora = dataHora
    )
}