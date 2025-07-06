package com.applab.foodfactory

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
   /* "Hello".printName()
    val sumResult = lambdaFn(3, 5) { x, y -> x + y }
    println("Sum of 3 and 5 is $sumResult")
    val res = lamdaFn(10,12) {a,b-> a*b }
    println("lamda. $res")*/
   runBlocking {
       val coldFlow = MutableStateFlow<String> ("s")
       val fl: StateFlow<String> = coldFlow
launch {
    delay(1000)
    coldFlow.value = "B"
    delay(1000)
    coldFlow.value = "B"
    delay(1000)
    coldFlow.value = "C"
}

       fl.collect {
           println("Collected: $it")
       }
   }


 /* val anon=   lambdaFn(7, 2, fun(x: Int, y: Int): Int {
        return x - y
    })
    println("Anonn is. $anon")*/
   /* someFunction("Hello",::println)
    someFunction("Good morning"){
        print(it)
    }*/
   /* inlineWithReturn({print("\narg1");return},{print("arg2")})//inline support return in lamda fn
    val list = (1..10).toList()*/
/*
    CoroutineScope(Dispatchers.IO).launch {
       // list.normalForEach(::println)
       /* list.normalForEach {
            delay(1000L)//normal fn don't giv coroutine scope inside dispatcher
        }*/
        //list.inlinedForEach (::println)
        list.inlinedForEach {
            delay(1000L) //gives coroutine context to run suspend fns
        }
    }*/
}

/* fun test(opt:(String)->Unit) {

}*/

inline fun <reified T> T.printName(){
    println(T::class.java.simpleName)
}


inline fun someFunction(str:String,opt:(String)->Unit){
    opt(str)
    //test(opt)

}

inline fun inlineWithReturn( fn1:()->Unit,fn2:()->Unit){
    fn1()
    fn2()
}
 fun <T> List<T>.normalForEach(action:(T)->Unit){
    for (item in this)
        action(item)
}

inline fun <T> List<T>.inlinedForEach(action:(T)->Unit){
    for (item in this)
        action(item)
}

fun lamdaFn(a:Int,b:Int,action:(Int,Int)->Int):Int{
    return action(a,b)
}
fun lambdaFn(a: Int, b: Int, action: (Int, Int) -> Int): Int {
    // Return the result of the lambda invocation
    return action(a, b)
}
interface  Abc{
    fun a()
}


