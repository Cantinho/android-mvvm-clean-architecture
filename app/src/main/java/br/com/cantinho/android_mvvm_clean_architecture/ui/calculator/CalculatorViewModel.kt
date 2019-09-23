package br.com.cantinho.android_mvvm_clean_architecture.ui.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    private val _operationResult = MutableLiveData<OperationResult>()
    val operationResult: LiveData<OperationResult> = _operationResult

    fun doAction(action: Action) {
        when(action){
            is Sum -> sum(action)
        }
    }

    private fun sum(action: Sum) {
        _operationResult.value = Success(action.paramA + action.paramB )
    }



}