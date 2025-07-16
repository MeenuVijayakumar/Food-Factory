package com.applab.foodfactory.testsamples

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ResourceComparerTest {
    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun setUp() {
        resourceComparer = ResourceComparer()
    }

    @Test
    fun compareString_return_true() {
        val result = resourceComparer.isEqualStringResource(
            ApplicationProvider.getApplicationContext<Context>(),
            com.applab.foodfactory.R.string.app_name,
            "FoodFactory"
        )
        assertEquals(true,result)

    }

    // @After

}