package com.example.calculadoraimc.data.repository

import com.example.calculadoraimc.data.local.dao.CalculoImcDao
import com.example.calculadoraimc.data.mapper.toDomain
import com.example.calculadoraimc.data.mapper.toEntity
import com.example.calculadoraimc.domain.model.CalculoImc
import com.example.calculadoraimc.domain.repository.CalculoImcRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CalculoImcRepositoryImpl @Inject constructor(private val dao: CalculoImcDao) : CalculoImcRepository {
    override fun obter(): Flow<List<CalculoImc>> {
        return dao.obter().map { entities -> entities.map { entity -> entity.toDomain() }}
    }

    override suspend fun obterPorId(id: Long): CalculoImc? {
        return dao.obterPorId(id)?.toDomain()
    }

    override suspend fun inserir(calculo: CalculoImc): Long {
        return dao.inserir(calculo.toEntity())
    }
}