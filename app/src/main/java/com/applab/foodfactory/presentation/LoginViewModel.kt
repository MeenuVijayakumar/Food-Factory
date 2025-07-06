package com.applab.foodfactory.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applab.foodfactory.data.AuthRepositoryImpl
import com.applab.foodfactory.data.RetrofitInstance
import com.applab.foodfactory.domain.LoginResponse
import com.applab.foodfactory.domain.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

sealed class LoginUiState {
    data object Idle : LoginUiState()
    data object Loading : LoginUiState()
    data class Success(val user: LoginResponse) : LoginUiState()
    data class Error(val message: String) : LoginUiState()
}

class LoginViewModel : ViewModel() {

    private val loginUseCase: LoginUseCase by lazy {
        val apiService = RetrofitInstance.api
        val repository = AuthRepositoryImpl(apiService)
        LoginUseCase(repository)
    }

    var email = mutableStateOf("emilys")
    var password = mutableStateOf("emilyspass")
    private var mutableLoginState = MutableStateFlow<LoginUiState?>(LoginUiState.Idle)
    val loginState = mutableLoginState
   // var errorMessage = mutableStateOf<String?>(null)

    suspend fun login() {
        viewModelScope.launch {
            loginState.value = LoginUiState.Loading
            try {
                val result = loginUseCase(email.value, password.value)
                loginState.value = LoginUiState.Success(result)
            } catch (e: Exception) {
                loginState.value = LoginUiState.Error(e.message?:"Error")
            }
        }
    }
}