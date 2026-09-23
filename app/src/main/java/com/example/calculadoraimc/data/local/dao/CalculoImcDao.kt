package com.example.calculadoraimc.data.local.dao

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.Query
import com.example.calculadoraimc.data.local.entity.CalculoImcEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CalculoImcDao {
    @Query("""
        SELECT
        *
        FROM calculo_imc
        ORDER BY dataHora DESC
    """)
    fun obter(): Flow<List<CalculoImcEntity>>

    @Query("""
        SELECT
        *
        FROM calculo_imc
        WHERE id = :id
        LIMIT 1
    """)
    suspend fun obterPorId(id: Long): CalculoImcEntity?

    @Insert
    suspend fun inserir(calculo: CalculoImcEntity): Long
}