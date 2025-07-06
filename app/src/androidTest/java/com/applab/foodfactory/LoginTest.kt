package com.applab.foodfactory

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.applab.foodfactory.xmll.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
class LoginTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)
    @Test
    fun testValidLogin_showSuccess(){
        onView(withId(R.id.etUname)).perform(typeText("admin"), closeSoftKeyboard())
        onView(withId(R.id.etPassword)).perform(typeText("1234"), closeSoftKeyboard())
        onView(withId(R.id.button_first)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Login success")))
    }
}