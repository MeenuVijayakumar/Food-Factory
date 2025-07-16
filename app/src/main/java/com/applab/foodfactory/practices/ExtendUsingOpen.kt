package com.applab.foodfactory.practices

open class ExtendUsingOpen {
    open val userName: String = "parent"
    val password: String = "password_parent"
    open fun isParent(str: String): Boolean {
        println("in parent $str//$userName")
        return userName == str
    }
}

class Derived : ExtendUsingOpen() {
    override val userName: String
        get() = "Derived"

    override fun isParent(str: String): Boolean {
        return str == userName
    }
}

sealed class UiState<T> {
    class Loading<T> : UiState<T>()
    data class Error<T>(val msg: String) : UiState<T>()
    data class Success<T>(val res: T) : UiState<T>()
}

fun <T> handleResponse(res: UiState<T>){
when(res){
    is UiState.Success<T> -> ""
    is UiState.Error<T> -> ""
    is UiState.Loading<T> -> ""
}
}




fun main() {
    val obj = Derived()
    println(obj.isParent(obj.userName))

}