package com.applab.foodfactory.testsamples

import com.applab.foodfactory.testsamples.RegistrationUtil.validateRegistrationInput
import org.junit.Assert.*
import org.junit.Test

class RegistrationUtilTest {
    @Test
    fun validateRegistration() {
        assertEquals(false,validateRegistrationInput("","","123"))
        assertEquals(false,validateRegistrationInput("Paul","123","123"))
    }

}