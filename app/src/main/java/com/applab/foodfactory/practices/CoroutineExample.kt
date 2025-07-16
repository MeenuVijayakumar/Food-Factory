package com.applab.foodfactory.practices

import com.applab.foodfactory.lamdaFn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main(): Unit = runBlocking(Dispatchers.IO) {
    // val job = SupervisorJob()
    /*supervisorScope {
        launch {
            throw RuntimeException("launch failed")
        }
        launch {
            val sum = { a: Int, b: Int -> a * b }
            println(sum(30, 40))
            println("helloo")

        }
    }*/

    supervisorScope {
        val r1= async { api1() }
        val r2= async { api2() }
        val res1= r1.await()
        val res2= r2.await()
       // if (res1.)
        println("$res2")
    }



}
suspend fun  api1(): String{
    delay(2000)
    throw RuntimeException("launch failed")
}
suspend fun  api2(): String{
    delay(2000)
    return "hello2"
}