package br.com.cantinho.android_mvvm_clean_architecture.cucumber.steps.espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import br.com.cantinho.android_mvvm_clean_architecture.R
import br.com.cantinho.android_mvvm_clean_architecture.ui.calculator.CalculatorActivity
import cucumber.api.java.After
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class FundamentalOperationsSteps{

    private val activityRule = ActivityTestRule(CalculatorActivity::class.java, false, false)

    @After
    fun finishActivity() {
        activityRule.finishActivity()
    }

    @Given("^I start the application\$")
    fun i_start_app(){
        activityRule.launchActivity(null)
    }

    @When("^I put a valid value in first text field (\\S+)\$")
    fun i_put_first_value(value1: String){
        onView(withId(R.id.tietParamA)).perform(typeText(value1), closeSoftKeyboard())
    }

    @And("^I put a valid value in second text field (\\S+)\$")
    fun i_put_second_value(value2: String){
        onView(withId(R.id.tietParamB)).perform(typeText(value2), closeSoftKeyboard())
    }

    @And("^I click on addiction button\$")
    fun i_click_on_addiction_btn(){
        onView(withId(R.id.btnPerformOperationAddiction)).perform(click())
    }

    @And("^I click on subtraction button\$")
    fun i_click_on_subtraction_btn(){
        onView(withId(R.id.btnPerformOperationSubtraction)).perform(click())
    }

    @And("^I click on multiplication button\$")
    fun i_click_on_multiplication_btn(){
        onView(withId(R.id.btnPerformOperationMultiplication)).perform(click())
    }

    @And("^I click on division button\$")
    fun i_click_on_division_btn(){
        onView(withId(R.id.btnPerformOperationDivision)).perform(click())
    }

    @Then("^I expect to see the result (\\S+)\$")
    fun i_expect_result(result: String) {
        onView(withId(R.id.textViewResult)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewResult)).check(matches(withText(result)))
    }
}