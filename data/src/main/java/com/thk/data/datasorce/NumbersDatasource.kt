package com.thk.data.datasorce

import androidx.lifecycle.LiveData
import com.thk.data.model.NumberEntity

interface NumbersDatasource {
    suspend fun getNumbers(): LiveData<List<NumberEntity>>
    suspend fun insertNumber(number: NumberEntity)
    suspend fun clearNumbers()
}

class NumbersDatasourceImpl : NumbersDatasource {
    override suspend fun getNumbers(): LiveData<List<NumberEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertNumber(number: NumberEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun clearNumbers() {
        TODO("Not yet implemented")
    }
}