package br.com.cantinho.android_mvvm_clean_architecture.ui.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.cantinho.android_mvvm_clean_architecture.R
import br.com.cantinho.android_mvvm_clean_architecture.ext.toInt
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {

    private lateinit var calculatorViewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        calculatorViewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)

        calculatorViewModel.operationResult.observe(this, Observer {
            when(it) {
                is Success -> textViewResult.text = it.result.toString()
            }
        })
        btnPerformOperation.setOnClickListener {
            calculatorViewModel.doAction(
                Sum(this@CalculatorActivity.tietParamA.toInt(), this@CalculatorActivity.tietParamB.toInt()))
        }
    }
}
