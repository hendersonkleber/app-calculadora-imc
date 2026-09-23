package com.example.calculadoraimc.data.di

import com.example.calculadoraimc.data.repository.CalculoImcRepositoryImpl
import com.example.calculadoraimc.domain.repository.CalculoImcRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCalculoImcRepository(
        implementation: CalculoImcRepositoryImpl
    ): CalculoImcRepository
}