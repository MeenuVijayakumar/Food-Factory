package com.applab.foodfactory.domain

interface AuthRepository {
    suspend fun login(request: LoginRequest): LoginResponse
}