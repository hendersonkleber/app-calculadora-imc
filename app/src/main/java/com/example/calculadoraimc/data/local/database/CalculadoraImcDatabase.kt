package com.example.calculadoraimc.data.local.database

import androidx.room3.Database
import androidx.room3.RoomDatabase
import com.example.calculadoraimc.data.local.dao.CalculoImcDao
import com.example.calculadoraimc.data.local.entity.CalculoImcEntity

@Database(
    entities = [
        CalculoImcEntity::class
    ],
    version = 1
)
abstract class CalculadoraImcDatabase : RoomDatabase() {
    abstract fun calculoImcDao(): CalculoImcDao
}