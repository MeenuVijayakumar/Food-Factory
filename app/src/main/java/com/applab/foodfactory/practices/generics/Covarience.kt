package com.applab.foodfactory.practices.generics

open class User(type:Int)

class Admin(): User(1)
class NormalUser(): User(2)

fun main(){
    val adminList = listOf<Admin>()
    val normalUserList= listOf<NormalUser>()
    val userList : List<User> = adminList

    val  userType1 = DerivedUser<NormalUser>()
    val  userType2 = DerivedUser2<Admin>()
    val userType3 : UserType<User> = userType1
    val userType4 : UserType<User> = userType2
}

open class UserType<out T>
class DerivedUser<T>: UserType<T>()
class DerivedUser2<T>: UserType<T>()


//open Ai apis
//train llm with data structure
//Bio Vl, open cv
//open AI, chat gpt llm, train AI
//commit msg - Commit Genie




