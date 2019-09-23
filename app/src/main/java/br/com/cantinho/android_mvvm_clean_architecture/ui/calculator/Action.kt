package br.com.cantinho.android_mvvm_clean_architecture.ui.calculator

sealed class Action {
}

data class Sum(val paramA: Int, val paramB: Int) : Action()
