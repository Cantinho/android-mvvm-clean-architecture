package br.com.cantinho.android_mvvm_clean_architecture.test

import cucumber.api.CucumberOptions;

@CucumberOptions(features = ["features"],
    glue = ["br.com.cantinho.android_mvvm_clean_architecture.cucumber.steps.espresso"],
    tags = ["@e2e", "@smoke"])
@SuppressWarnings("unused")
class CucumberTestCase