package com.applab.foodfactory.testsamples

import com.applab.foodfactory.domain.LoginResponse
import com.applab.foodfactory.philip.other.ApiResult
import com.applab.foodfactory.philip.other.safeApiCall2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import java.io.IOException

@ExperimentalCoroutinesApi
class SafeApiCallTest {

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `safeApiCall returns success`() = runTest {
        val expectedResponse = LoginResponse("abc123", "meenuv", "Meenu")
        val response = Response.success(expectedResponse)

        val result = safeApiCall2 { response }

        assertTrue(result is ApiResult.Success)
        assertEquals(expectedResponse, (result as ApiResult.Success).data)
    }

    @Test
    fun `safeApiCall returns http error`() = runTest {
        val errorResponse = Response.error<LoginResponse>(
            404,
            "User not found".toResponseBody("application/json".toMediaType())
        )

        val result = safeApiCall2 { errorResponse }

        assertTrue(result is ApiResult.Error)
        assertEquals(404, (result as ApiResult.Error).code)
    }

    @Test
    fun `safeApiCall retries on IOException and returns exception`() = runTest {
        var attempt = 0
        val result = safeApiCall2<LoginResponse>(retries = 2, delayMillis = 0) {
            attempt++
            throw IOException("No internet")
        }

        assertTrue(result is ApiResult.Exception)
        assertEquals(2, attempt)
    }

   /* @Test
    fun `safeApiCall handles JSON exception`() = runTest {
        val result = safeApiCall<LoginResponse> {
            throw JsonDataException("Unexpected token")
        }

        assertTrue(result is ApiResult.Exception)
        assertTrue((result as ApiResult.Exception).exception is JsonDataException)
    }*/
}
