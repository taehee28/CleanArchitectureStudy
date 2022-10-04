package com.thk.domain.di

import com.thk.domain.repository.NumbersRepository
import com.thk.domain.usecase.ClearNumbersUseCase
import com.thk.domain.usecase.GetNumbersUseCase
import com.thk.domain.usecase.InsertNumberUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Singleton
    @Provides
    fun provideGetNumbersUseCase(repository: NumbersRepository) = GetNumbersUseCase(repository)

    @Singleton
    @Provides
    fun provideInsertNumberUseCase(repository: NumbersRepository) = InsertNumberUseCase(repository)

    @Singleton
    @Provides
    fun provideClearNumbersUseCase(repository: NumbersRepository) = ClearNumbersUseCase(repository)
}