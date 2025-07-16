package com.applab.foodfactory.dsa

import com.applab.foodfactory.practices.UiState

/**
 * swap two numbers with out 3rd variable
 */
/*fun main() {

    var a = 10
    var b = 20
    print("before swap a= $a and b=$b\n")
    //meth1
    /* a += b
     b = a-b
     a -= b*/
    //meth 2 using scope fn
    b = a.also { a = b }
    println("after swap a= $a and b=$b")
}*/

fun main() {
    var str = "12345"
    var reversedStr = ""

    for (i in str.length - 1 downTo 0) {
        reversedStr += str[i]
    }
    if (str.lowercase().trim()==reversedStr.lowercase().trim())
    println("string is palindrome")
    else
    println("string is not palindrome")
}

