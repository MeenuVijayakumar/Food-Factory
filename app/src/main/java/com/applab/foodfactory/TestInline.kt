package com.applab.foodfactory

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    "Hello".printName()
    someFunction("Hello",::println)
    someFunction("Good morning"){
        print(it)
    }
    inlineWithReturn({print("\narg1");return},{print("arg2")})//inline support return in lamda fn
    val list = (1..10).toList()

    CoroutineScope(Dispatchers.IO).launch {
       // list.normalForEach(::println)
       /* list.normalForEach {
            delay(1000L)//normal fn don't giv coroutine scope inside dispatcher
        }*/
        //list.inlinedForEach (::println)
        list.inlinedForEach {
            delay(1000L) //gives coroutine context to run suspend fns
        }
    }
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

