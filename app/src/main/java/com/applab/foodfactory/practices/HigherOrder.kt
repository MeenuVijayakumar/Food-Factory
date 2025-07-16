package com.applab.foodfactory.practices

import android.app.AlertDialog
import android.content.Context

fun main() {
    val user: (String) -> Unit = {
        println("User is $it")
    }
    user("Meenu V")
    fun calculate(var1: Int, var2: Int, operation: (Int, Int) -> Int): Int {
        return operation(var1, var2)
    }
    println(calculate(10, 20) { a, b -> a * b })

    val lamdaWithReceiver: String.() -> Unit = {
        println("User is $this")
    }
   "Lamda with Receiver".lamdaWithReceiver()

    fun buildWithString(action: StringBuilder.(String, String)-> Unit): String{
        val sb = StringBuilder()
        sb.action("Hello","Good morning")
        return sb.toString()
    }

   val result =  buildWithString {a,b->
        append("begin")
        append(a)
        append(b)
        append("end")
    }
    println(result)

}