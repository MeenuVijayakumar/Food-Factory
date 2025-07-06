package com.applab.foodfactory

import com.applab.foodfactory.xmll.vm.LoginVm
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.runner.RunWith

@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
class LoginViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var vm:LoginVm

    @Before
    fun setUp(){
        vm = LoginVm()
    }

    @Test
    fun login_success_returnsSuccessMessage() {
        vm.login("admin", "1234")
        assertEquals("Login successful", vm.loginResult.value)
    }
}