package com.applab.foodfactory.domain

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): LoginResponse {
        return repository.login(LoginRequest(email, password))
    }
}