package com.example.calculadoraimc.domain.repository

import com.example.calculadoraimc.domain.model.CalculoImc
import kotlinx.coroutines.flow.Flow

interface CalculoImcRepository {
    fun obter(): Flow<List<CalculoImc>>
    suspend fun obterPorId(id: Long): CalculoImc?
    suspend fun inserir(calculo: CalculoImc): Long
}