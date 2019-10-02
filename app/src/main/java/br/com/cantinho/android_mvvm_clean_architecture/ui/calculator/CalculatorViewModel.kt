package br.com.cantinho.android_mvvm_clean_architecture.ui.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.cantinho.android_mvvm_clean_architecture.ui.calculator.usecases.AddictionUseCase
import br.com.cantinho.android_mvvm_clean_architecture.ui.calculator.usecases.DivisionUseCase
import br.com.cantinho.android_mvvm_clean_architecture.ui.calculator.usecases.MultiplicationUseCase
import br.com.cantinho.android_mvvm_clean_architecture.ui.calculator.usecases.SubtractionUseCase

class CalculatorViewModel: ViewModel() {

    private val _operationResult = MutableLiveData<OperationResult>()
    val operationResult: LiveData<OperationResult> = _operationResult

    private val addictionUseCase = AddictionUseCase()
    private val subtractionUseCase = SubtractionUseCase()
    private val multiplicationUseCase = MultiplicationUseCase()
    private val divisionUseCase = DivisionUseCase()


    fun doAction(action: Action) {
        when(action){
            is Sum -> _operationResult.value = addictionUseCase.perform( action.paramA, action.paramB )
            is Subtract -> _operationResult.value = subtractionUseCase.perform( action.paramA, action.paramB )
            is Multiply -> _operationResult.value = multiplicationUseCase.perform( action.paramA, action.paramB )
            is Divide -> _operationResult.value = divisionUseCase.performn( action.paramA, action.paramB )

        }
    }
}