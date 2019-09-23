package br.com.cantinho.android_mvvm_clean_architecture.ui.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.cantinho.android_mvvm_clean_architecture.R
import br.com.cantinho.android_mvvm_clean_architecture.ext.toInt
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var calculatorViewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        calculatorViewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)

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
