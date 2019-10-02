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

        btnPerformOperationAddiction.setOnClickListener {
            calculatorViewModel.doAction(
                Sum(this@CalculatorActivity.tietParamA.toInt(), this@CalculatorActivity.tietParamB.toInt()))
        }

        btnPerformOperationSubtraction.setOnClickListener {
            calculatorViewModel.doAction(
                Subtract(this@CalculatorActivity.tietParamA.toInt(), this@CalculatorActivity.tietParamB.toInt()))
        }

        btnPerformOperationMultiplication.setOnClickListener {
            calculatorViewModel.doAction(
                Multiply(this@CalculatorActivity.tietParamA.toInt(), this@CalculatorActivity.tietParamB.toInt()))
        }

        btnPerformOperationDivision.setOnClickListener {
            calculatorViewModel.doAction(
                Divide(this@CalculatorActivity.tietParamA.toInt(), this@CalculatorActivity.tietParamB.toInt()))
        }
    }
}
