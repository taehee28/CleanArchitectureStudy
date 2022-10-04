package com.thk.data.repository

import androidx.lifecycle.LiveData
import com.thk.data.model.NumberEntity
import com.thk.domain.model.NumberModel

interface NumbersRepository {
    suspend fun getNumbers(): LiveData<List<NumberModel>>
    suspend fun insertNumber(number: NumberModel)
    suspend fun clearNumbers()
}

class NumbersRepositoryImpl : NumbersRepository {
    override suspend fun getNumbers(): LiveData<List<NumberModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertNumber(number: NumberModel) {
        TODO("Not yet implemented")
    }

    override suspend fun clearNumbers() {
        TODO("Not yet implemented")
    }
}