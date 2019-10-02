package br.com.cantinho.android_mvvm_clean_architecture

import android.app.Application
import br.com.cantinho.android_mvvm_clean_architecture.di.AppInjection

class CalculatorApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        AppInjection.init(this)

    }
}