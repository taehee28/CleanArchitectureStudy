package com.thk.cleanarchitecturestudy.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thk.domain.model.NumberModel
import com.thk.domain.usecase.ClearNumbersUseCase
import com.thk.domain.usecase.GetNumbersAsFlowUseCase
import com.thk.domain.usecase.GetNumbersUseCase
import com.thk.domain.usecase.InsertNumberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNumbersUseCase: GetNumbersUseCase,
    private val getNumbersAsFlowUseCase: GetNumbersAsFlowUseCase,
    private val insertNumberUseCase: InsertNumberUseCase,
    private val clearNumbersUseCase: ClearNumbersUseCase
) : ViewModel() {
    val numbers: LiveData<List<NumberModel>> = getNumbersUseCase()

    val numbersFlow: StateFlow<List<NumberModel>> = getNumbersAsFlowUseCase().stateIn(
        initialValue = emptyList(),
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000)
    )

    fun insertNumber(value: Int) = viewModelScope.launch {
        insertNumberUseCase(value)
    }

    fun clearNumbers() = viewModelScope.launch {
        clearNumbersUseCase()
    }
}