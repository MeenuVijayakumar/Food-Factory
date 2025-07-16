package com.applab.foodfactory.testsamples

object RegistrationUtil {
    private val existingUsers = listOf("Paul", "John")

    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (username.isEmpty() || password.isEmpty())
            return false
        if (username in existingUsers)
            return false
        if (password != confirmPassword)
            return false
        if (password.count { it.isDigit() } < 2)
            return false
        return true

    }
}