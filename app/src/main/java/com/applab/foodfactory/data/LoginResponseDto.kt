package com.applab.foodfactory.data

import com.applab.foodfactory.domain.LoginResponse

data class LoginResponseDto(val accessToken: String, val username: String,val email:String) {
    fun toDomain() = LoginResponse(accessToken, username,email)
}