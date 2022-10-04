package com.thk.data.di

import android.content.Context
import androidx.room.Room
import com.thk.data.database.NumbersDao
import com.thk.data.database.NumbersDatabase
import com.thk.data.datasource.LocalDataSource
import com.thk.data.datasource.LocalDataSourceImpl
import com.thk.data.repository.NumbersRepository
import com.thk.data.repository.NumbersRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    /**
     * [NumbersRepository]의 인스턴스를 생성하는 방법을 명시
     */
    @Singleton
    @Provides
    fun provideNumbersRepository(dataSource: LocalDataSource): NumbersRepository =
        NumbersRepositoryImpl(dataSource)
}

@Module
@InstallIn(SingletonComponent::class)
object DatasourceModule {
    /**
     * [LocalDataSource]의 인스턴스를 생성하는 방법을 명시
     */
    @Singleton
    @Provides
    fun provideLocalDataSource(dao: NumbersDao): LocalDataSource = LocalDataSourceImpl(dao)
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    /**
     * [NumbersDao] 인스턴스를 생성하는 방법을 명시
     */
    @Singleton
    @Provides
    fun provideNumbersDao(database: NumbersDatabase): NumbersDao = database.dao()

    /**
     * [NumbersDatabase] 인스턴스를 생성하는 방법을 명시
     */
    @Singleton
    @Provides
    fun provideNumbersDatabase(@ApplicationContext appContext: Context): NumbersDatabase =
        Room.databaseBuilder(
            appContext,
            NumbersDatabase::class.java,
            "numbersdb"
        ).build()
}