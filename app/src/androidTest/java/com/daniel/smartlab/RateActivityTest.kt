package com.daniel.smartlab

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.daniel.smartlab.presentation.model.Rating
import com.daniel.smartlab.presentation.presenter.RatePresenter
import com.daniel.smartlab.presentation.view.RateActivity
import com.daniel.smartlab.presentation.view.recycler.RatingHolder

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import java.util.concurrent.RecursiveAction

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class RateActivityTest {

//    val activity : RateActivity = RateActivity()

    @Rule @JvmField
    public var rule = ActivityTestRule<RateActivity>(RateActivity::class.java)

    lateinit var act : RateActivity
    @Mock
    lateinit var presenter : RatePresenter

    @Before
    fun init() {
        presenter = Mockito.mock(RatePresenter::class.java)
        act = rule.activity
//        Mockito.mock()
        act.presenter = presenter
    }

    @Test
    fun saveRating() {

//        Mockito.`when`(presenter.save(Rating()))
//
        val captor = ArgumentCaptor.forClass(Rating::class.java)

        //TODO Proper capture
        verify(presenter, times(1)).save(captor.capture())

        onView(withId(R.id.radioButton2)).perform(click())

        onView(withId(R.id.ratingsList))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RatingHolder>(0, click()))

        onView(withId(R.id.fab)).perform(click())
        print(captor.value)
    }
}
