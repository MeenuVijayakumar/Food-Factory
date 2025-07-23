package com.applab.foodfactory.practices


fun main() {

   /* var guestUser : User?=null
    println(guestUser?.name?:"Default name")
    guestUser = User(age = 10, name = "Aitha")
    guestUser.name?.let { println(it) }
    guestUser.name?.apply { this.uppercase().also { it.replaceFirstChar { it.lowercase() }.also { println(it) } } }
   */ val name: String? = "Meenu"
   val lenght =name?.run {
       // println("Name is $this")
        "Name is $this"
        length
    }
    println(lenght)
}
class ScopeFunctions {
}

data class User(
    var name: String?=null,
    var age:Int?=null
)