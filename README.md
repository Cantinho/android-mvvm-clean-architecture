# android-mvvm-clean-architecture
android-mvvm-clean-architecture

## Instrumentation tests with Cumcumber + Espresso
To run cucumber tests cases with Espresso steps, execute:

```
./gradlew connectedCheck -Pcucumber
```

## Instrumentation tests with Cumcumber + Appium
To run cucumber tests cases with Appium Steps, follow steps bellow:

###### 1 - Install and start Appium server using default address and port (http://localhost:4723/)

###### 2 - Change glue attribute in the CucumberTestCase to:

```
glue = ["br.com.cantinho.android_mvvm_clean_architecture.cucumber.steps.appium"]
```

###### 3 - In the AndroidStudio, on project window, click with left button in androidTest folder, and click with left button in androidTest folder and click on "Run 'All Features in: androidTest'"
