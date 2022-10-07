package com.thk.data.datasource

import androidx.lifecycle.LiveData
import com.thk.data.database.NumbersDao
import com.thk.data.model.NumberEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface LocalDataSource {
    fun getNumbers(): LiveData<List<NumberEntity>>
    fun getNumbersAsFlow(): Flow<List<NumberEntity>>
    suspend fun insertNumber(number: NumberEntity)
    suspend fun clearNumbers()
}

class LocalDataSourceImpl @Inject constructor(private val dao: NumbersDao) : LocalDataSource {
    override fun getNumbers(): LiveData<List<NumberEntity>> {
        return dao.getNumbers()
    }

    override fun getNumbersAsFlow(): Flow<List<NumberEntity>> {
        return dao.getNumbersAsFlow()
    }

    override suspend fun insertNumber(number: NumberEntity) {
        dao.insertNumber(number)
    }

    override suspend fun clearNumbers() {
        dao.clearNumbers()
    }
}