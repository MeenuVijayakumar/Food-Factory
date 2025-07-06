package com.applab.foodfactory.login

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.action.ViewActions.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.applab.foodfactory.R
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
    }
}