package br.com.cantinho.android_mvvm_clean_architecture.ui.calculator.usecases

import br.com.cantinho.android_mvvm_clean_architecture.R
import br.com.cantinho.android_mvvm_clean_architecture.ui.calculator.Error
import br.com.cantinho.android_mvvm_clean_architecture.ui.calculator.OperationResult
import br.com.cantinho.android_mvvm_clean_architecture.ui.calculator.Success

class DivisionUseCase {

    fun performDivision(paramA: Int, paramB: Int): OperationResult {

        if (paramB == 0) {
            return Error(R.string.division_failed)
        }

        return Success( paramA / paramB )
    }
}