package com.thk.domain.usecase

import androidx.lifecycle.LiveData
import com.thk.domain.model.NumberModel
import com.thk.domain.repository.NumbersRepository

/*
    각 기능 별 UseCase 클래스 정의 
 */

class GetNumbersUseCase(private val repository: NumbersRepository) {
    operator fun invoke(): LiveData<List<NumberModel>> {
        return repository.getNumbers()
    }
}

class InsertNumberUseCase(private val repository: NumbersRepository) {
    suspend operator fun invoke(value: Int) {
        val number = NumberModel(id = 0, value = value)
        repository.insertNumber(number)
    }
}

class ClearNumbersUseCase(private val repository: NumbersRepository) {
    suspend operator fun invoke() {
        repository.clearNumbers()
    }
}