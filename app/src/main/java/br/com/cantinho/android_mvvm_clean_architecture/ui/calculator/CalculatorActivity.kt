package br.com.cantinho.android_mvvm_clean_architecture.ui.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import br.com.cantinho.android_mvvm_clean_architecture.R
import br.com.cantinho.android_mvvm_clean_architecture.ext.toInt
import kotlinx.android.synthetic.main.activity_calculator.*
import org.koin.android.ext.android.inject

class CalculatorActivity : AppCompatActivity(), View.OnClickListener {

    // lazy inject BusinessService into property
    private val calculatorViewModel : CalculatorViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        calculatorViewModel.operationResult.observe(this, Observer {
            when(it) {
                is Success -> textViewResult.text = it.result.toString()
                is Error -> textViewResult.text = getString(it.message)
            }
        })
    }

    override fun onClick(view: View) {

        when(view.id) {
            R.id.btnPerformOperationAddiction -> calculatorViewModel.doAction(Sum(this@CalculatorActivity.tietParamA.toInt(), this@CalculatorActivity.tietParamB.toInt()))
            R.id.btnPerformOperationSubtraction -> calculatorViewModel.doAction(Subtract(this@CalculatorActivity.tietParamA.toInt(), this@CalculatorActivity.tietParamB.toInt()))
            R.id.btnPerformOperationMultiplication -> calculatorViewModel.doAction(Multiply(this@CalculatorActivity.tietParamA.toInt(), this@CalculatorActivity.tietParamB.toInt()))
            R.id.btnPerformOperationDivision -> calculatorViewModel.doAction(Divide(this@CalculatorActivity.tietParamA.toInt(), this@CalculatorActivity.tietParamB.toInt()))

        }

    }
}
