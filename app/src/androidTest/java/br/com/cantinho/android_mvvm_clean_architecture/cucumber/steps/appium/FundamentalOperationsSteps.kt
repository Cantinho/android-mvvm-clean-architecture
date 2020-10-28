package br.com.cantinho.android_mvvm_clean_architecture.cucumber.steps.appium

import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.junit.Assert
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.net.URL

class FundamentalOperationsSteps{

    lateinit var driver: AndroidDriver<MobileElement>
    lateinit var wait: WebDriverWait
    var caps: DesiredCapabilities = ProjectCapabilities.AndroidBaseCapabilities()
    var webDriverURL: URL = URL("http://localhost:4723/wd/hub")

    //Element IDs
    private val etParamAId = "br.com.cantinho.android_mvvm_clean_architecture:id/tietParamA"
    private val etParamBId = "br.com.cantinho.android_mvvm_clean_architecture:id/tietParamB"
    private val etResId = "br.com.cantinho.android_mvvm_clean_architecture:id/textViewResult"
    private val btAddId = "br.com.cantinho.android_mvvm_clean_architecture:id/btnPerformOperationAddiction"
    private val btSubId = "br.com.cantinho.android_mvvm_clean_architecture:id/btnPerformOperationSubtraction"
    private val btMulId = "br.com.cantinho.android_mvvm_clean_architecture:id/btnPerformOperationMultiplication"
    private val btDivId = "br.com.cantinho.android_mvvm_clean_architecture:id/btnPerformOperationDivision"

    @After
    fun tearDown() {
        driver.quit()
    }

    @Given("^I start the application\$")
    fun i_start_app(){
        driver = AndroidDriver<MobileElement>(webDriverURL, caps)
        wait = WebDriverWait(driver, 5)
    }

    @When("^I put a valid value in first text field (\\S+)\$")
    fun i_put_first_value(value1: String){
        driver.findElementById(etParamAId).sendKeys(value1);
    }

    @And("^I put a valid value in second text field (\\S+)\$")
    fun i_put_second_value(value2: String){
        driver.findElementById(etParamBId).sendKeys(value2);
    }

    @And("^I click on addiction button\$")
    fun i_click_on_addiction_btn(){
        driver.findElementById(btAddId).click();
    }

    @And("^I click on subtraction button\$")
    fun i_click_on_subtraction_btn(){
        driver.findElementById(btSubId).click();
    }

    @And("^I click on multiplication button\$")
    fun i_click_on_multiplication_btn(){
        driver.findElementById(btMulId).click();
    }

    @And("^I click on division button\$")
    fun i_click_on_division_btn(){
        driver.findElementById(btDivId).click();
    }

    @Then("^I expect to see the result (\\S+)\$")
    fun i_expect_result(expectedResult: String) {
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id(etResId))).isDisplayed
        var actualResult = driver.findElementById(etResId).text
        Assert.assertEquals(expectedResult, actualResult)
    }
}