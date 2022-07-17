package com.nytimes.core.di

import com.nytimes.utils.NoInternetException
import com.nytimes.utils.Utils
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * @author: MOHAMMAD MISBAH
 * @since: 16-Jul-2022
 * @sample: Technology Assessment for Android Role
 * @desc NetworkConnectionInterceptor is for the network layer
 * Email Id: mohammadmisbahazmi@gmail.com
 * GitHub: https://github.com/misbahazmi
 * Expertise: Android||Java||Flutter
 */
class NetworkConnectionInterceptor @Inject constructor(val utils: Utils): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if(!utils.isNetworkAvailable())
            throw NoInternetException("Make sure you have an active internet connection.")
        return chain.proceed(chain.request())
    }
}