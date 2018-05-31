package com.daniel.smartlab

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.runner.AndroidJUnit4
import com.daniel.smartlab.presentation.view.RateActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

//    val activity : RateActivity = RateActivity()

    @Test
    fun saveRating() {
        onView(withId(R.id.radioButton2)).perform(click())
        onView(withId(R.id.fab)).perform(click())

    }


    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.daniel.smartlab", appContext.packageName)
    }
}
