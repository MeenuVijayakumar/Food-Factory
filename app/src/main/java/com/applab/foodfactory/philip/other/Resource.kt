package com.applab.foodfactory.philip.other

import kotlinx.coroutines.delay
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import kotlin.coroutines.cancellation.CancellationException

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}

sealed class ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error(val code: Int, val message: String?) : ApiResult<Nothing>()
    data class Exception(val exception: Throwable) : ApiResult<Nothing>()
    data object Loading: ApiResult<Nothing>()
}

suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): ApiResult<T> {
    return try {
        val response = apiCall()
        if (response.isSuccessful) {
            response.body()?.let {
                ApiResult.Success(it)
            } ?: ApiResult.Error(response.code(), "Empty response body")
        } else {
            ApiResult.Error(response.code(), response.errorBody()?.string())
        }
    } catch (e: CancellationException) {
        throw e // Always rethrow cancellation exceptions
    } catch (e: IOException) {
        ApiResult.Exception(e) // Network error
    } catch (e: HttpException) {
        ApiResult.Exception(e) // HTTP error
    }
   /* catch (e: JsonDataException) {
        ApiResult.Exception(e) // JSON parsing error (Moshi)
    }*/ catch (e: Exception) {
        ApiResult.Exception(e) // Fallback for unexpected exceptions
    }
}

suspend fun <T> safeApiCall2(
    retries: Int = 2,
    delayMillis: Long = 100,
    apiCall: suspend () -> Response<T>
): ApiResult<T> {
    repeat(retries) { attempt ->
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                return response.body()?.let { ApiResult.Success(it) }
                    ?: ApiResult.Error(response.code(), "Empty body")
            } else {
                return ApiResult.Error(response.code(), response.errorBody()?.string())
            }
        } catch (e: IOException) {
            if (attempt == retries - 1) return ApiResult.Exception(e)
            delay(delayMillis)
        } catch (e: Exception) {
            return ApiResult.Exception(e)
        }
    }
    return ApiResult.Exception(Exception("Unknown"))
}