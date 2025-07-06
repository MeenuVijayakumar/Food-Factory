package com.applab.foodfactory.data

import com.applab.foodfactory.domain.AuthRepository
import com.applab.foodfactory.domain.LoginRequest
import com.applab.foodfactory.domain.LoginResponse

class AuthRepositoryImpl(private val api: AuthApiService) : AuthRepository {
    override suspend fun login(request: LoginRequest): LoginResponse {
        val dto = LoginRequestDto(request.username, request.password)
        return api.login(dto).toDomain()
    }
}