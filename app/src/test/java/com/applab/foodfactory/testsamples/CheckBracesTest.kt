package com.applab.foodfactory.testsamples

import org.junit.Assert.*
import org.junit.Test

class CheckBracesTest {
    @Test
    fun checkBracesTrue() {
        assertEquals(true,checkBraces("()"))
        assertEquals(true,checkBraces("((()))"))
    }

    @Test
    fun checkBracesFalse(){
        assertEquals(false,checkBraces("2324)"))
    }

}