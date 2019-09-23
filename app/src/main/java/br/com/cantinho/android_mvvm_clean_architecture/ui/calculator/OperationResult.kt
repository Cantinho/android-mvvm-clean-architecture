package br.com.cantinho.android_mvvm_clean_architecture.ui.calculator

sealed class OperationResult {
}

object Idle : OperationResult()

data class Success(val result: Int) : OperationResult()

data class Error(val message: Int) : OperationResult()
