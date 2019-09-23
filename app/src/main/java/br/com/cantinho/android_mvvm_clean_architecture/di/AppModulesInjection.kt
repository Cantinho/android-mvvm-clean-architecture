package br.com.cantinho.android_mvvm_clean_architecture.di

import br.com.cantinho.android_mvvm_clean_architecture.ui.calculator.CalculatorViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { CalculatorViewModel() }
}

val repositoryModule = module {

}