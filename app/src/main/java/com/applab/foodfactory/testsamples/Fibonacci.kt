package com.applab.foodfactory.testsamples

/**
 * function return the nth fibonacci  number
 */
fun fib(n: Int): Long {
    if (n == 0 || n == 1) {
        return n.toLong()
    }
    var a = 0L
    var b = 1L
    var c = 0L  // Declare 'c' here
    for (i in 1 until n) {  // Use until to avoid index n-2
        c = a + b
        a = b
        b = c
    }
    return c
}

/**
 * Checks if the braces are set correctly
 * e.g. "(a * b))" should return false
 */
fun checkBraces(string: String): Boolean {
    return string.count { it == '(' } == string.count { it == ')' }
}