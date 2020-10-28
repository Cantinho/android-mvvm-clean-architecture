package br.com.cantinho.android_mvvm_clean_architecture.cucumber.steps.appium

import org.openqa.selenium.remote.DesiredCapabilities

class ProjectCapabilities {
    companion object {
        fun AndroidBaseCapabilities(): DesiredCapabilities {
            val caps = DesiredCapabilities()
            caps.setCapability("platformName", "Android")
            caps.setCapability("automatorName", "UiAutomator2")
            caps.setCapability("deviceName", "0059786205")
            caps.setCapability("appPackage", "br.com.cantinho.android_mvvm_clean_architecture")
            caps.setCapability("appActivity", ".ui.calculator.CalculatorActivity")
            return caps
        }
    }
}