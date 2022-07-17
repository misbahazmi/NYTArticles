package com.nytimes.core.base

import com.nytimes.core.data.remote.APIResult
import com.nytimes.utils.AppLog
import com.nytimes.utils.NoInternetException
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResults(call: suspend ()->Response<T>) : APIResult<T>{
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return APIResult.success(body)
            }
            return error("${response.code()} : ${response.message()}")
        }
        catch (e: NoInternetException){
            return APIResult.error(message = e.message.toString())
        }
        catch (e: Exception){
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): APIResult<T>{
        AppLog.debugE(message)
        return APIResult.error(message = "Network call has failed due to the reason: $message" )
    }
}