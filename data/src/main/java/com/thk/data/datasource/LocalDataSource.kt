package com.thk.data.datasource

import androidx.lifecycle.LiveData
import com.thk.data.database.NumbersDao
import com.thk.data.model.NumberEntity
import javax.inject.Inject

interface LocalDataSource {
    suspend fun getNumbers(): LiveData<List<NumberEntity>>
    suspend fun insertNumber(number: NumberEntity)
    suspend fun clearNumbers()
}

class LocalDataSourceImpl @Inject constructor(private val dao: NumbersDao) : LocalDataSource {
    override suspend fun getNumbers(): LiveData<List<NumberEntity>> {
        return dao.getNumbers()
    }

    override suspend fun insertNumber(number: NumberEntity) {
        dao.insertNumber(number)
    }

    override suspend fun clearNumbers() {
        dao.clearNumbers()
    }
}