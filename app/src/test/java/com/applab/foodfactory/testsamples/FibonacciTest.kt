package com.applab.foodfactory.testsamples

import org.junit.Assert.*
import org.junit.Test

class FibonacciTest {
    @Test
    fun testFib0() {
    assertEquals(0L,fib(0))
    }
    @Test
    fun testFib1(){
        assertEquals(1L,fib(1))
    }
    @Test
    fun testFib2(){
        assertEquals(1L,fib(2))
    }
    @Test
    fun testFib3(){
        assertEquals(3L,fib(4))
    }
    @Test
    fun testFib5(){
        assertEquals(5L,fib(5))
    }
    @Test
    fun testFib8(){
        assertEquals(8L,fib(6))
    }
}