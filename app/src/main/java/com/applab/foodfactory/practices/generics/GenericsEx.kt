package com.applab.foodfactory.practices.generics

class GenericsEx<T>(val content: T) {
    fun printT() {
        println("content$content")
    }

    fun <T> show(item: T) {
        println("Function generic $item")
    }
}

fun main() {
    val a = GenericsEx("Hello sting here")
    a.printT()
    a.show(123)
    val b = GenericsEx(123)
    b.printT()
    b.show("hfdhcf")
}