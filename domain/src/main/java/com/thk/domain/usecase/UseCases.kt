package com.thk.domain.usecase

import androidx.lifecycle.LiveData
import com.thk.domain.model.NumberModel
import com.thk.domain.repository.NumbersRepository
import javax.inject.Inject

/*
    각 기능 별 UseCase 클래스 정의 
 */

class GetNumbersUseCase @Inject constructor(private val repository: NumbersRepository) {
    suspend operator fun invoke(): LiveData<List<NumberModel>> {
        return repository.getNumbers()
    }
}

class InsertNumberUseCase @Inject constructor(private val repository: NumbersRepository) {
    suspend operator fun invoke(value: Int) {
        val number = NumberModel(value)
        repository.insertNumber(number)
    }
}

class ClearNumbersUseCase @Inject constructor(private val repository: NumbersRepository) {
    suspend operator fun invoke() {
        repository.clearNumbers()
    }
}