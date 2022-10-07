package com.thk.domain.repository

import androidx.lifecycle.LiveData
import com.thk.domain.model.NumberModel
import kotlinx.coroutines.flow.Flow

/**
 * 해당 인터페이스의 구현 클래스는 data 레이어에 존재함
 */
interface NumbersRepository {
    fun getNumbers(): LiveData<List<NumberModel>>
    fun getNumbersAsFlow(): Flow<List<NumberModel>>
    suspend fun insertNumber(number: NumberModel)
    suspend fun clearNumbers()
}