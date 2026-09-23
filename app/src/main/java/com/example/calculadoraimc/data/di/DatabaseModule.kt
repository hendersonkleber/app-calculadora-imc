package com.example.calculadoraimc.data.di

import android.content.Context
import androidx.room3.Room
import com.example.calculadoraimc.data.local.dao.CalculoImcDao
import com.example.calculadoraimc.data.local.database.CalculadoraImcDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): CalculadoraImcDatabase {
        return Room.databaseBuilder(
            context,
            CalculadoraImcDatabase::class.java,
            "calculadora_imc.db"
        ).build()
    }

    @Provides
    fun provideCalculoImcDao(
        database: CalculadoraImcDatabase
    ): CalculoImcDao {
        return database.calculoImcDao()
    }
}