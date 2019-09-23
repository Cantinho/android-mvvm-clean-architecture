package br.com.cantinho.android_mvvm_clean_architecture.ui.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.cantinho.android_mvvm_clean_architecture.ui.calculator.usecases.SumUseCase

class CalculatorViewModel: ViewModel() {

    private val _operationResult = MutableLiveData<OperationResult>()
    val operationResult: LiveData<OperationResult> = _operationResult

    private val sumUseCase = SumUseCase()

    fun doAction(action: Action) {
        when(action){
            is Sum -> _operationResult.value = sumUseCase.performSum( action.paramA, action.paramB )
        }
    }



}