package br.com.cantinho.android_mvvm_clean_architecture

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented br.com.cantinho.android_mvvm_clean_architecture.test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under br.com.cantinho.android_mvvm_clean_architecture.test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("br.com.cantinho.android_mvvm_clean_architecture", appContext.packageName)
    }
}
