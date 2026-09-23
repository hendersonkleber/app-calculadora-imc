package com.example.calculadoraimc.data.local.entity

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "calculo_imc")
data class CalculoImcEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val peso: Double,
    val altura: Double,
    val imc: Double,
    val classificacao: String,
    val dataHora: Long
)