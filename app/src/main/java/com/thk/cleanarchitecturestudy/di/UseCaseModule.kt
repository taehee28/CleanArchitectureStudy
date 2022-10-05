package com.thk.cleanarchitecturestudy.di

import com.thk.domain.repository.NumbersRepository
import com.thk.domain.usecase.ClearNumbersUseCase
import com.thk.domain.usecase.GetNumbersUseCase
import com.thk.domain.usecase.InsertNumberUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetNumbersUseCase(repository: NumbersRepository) = GetNumbersUseCase(repository)

    @Provides
    fun provideInsertNumberUseCase(repository: NumbersRepository) = InsertNumberUseCase(repository)

    @Provides
    fun provideClearNumbersUseCase(repository: NumbersRepository) = ClearNumbersUseCase(repository)
}