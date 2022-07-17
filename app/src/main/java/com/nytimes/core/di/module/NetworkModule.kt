package com.nytimes.core.di.module

import com.nytimes.BuildConfig
import com.nytimes.core.data.remote.APIService
import com.nytimes.core.di.NetworkConnectionInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
/**
 * @author: MOHAMMAD MISBAH
 * @since: 16-Jul-2022
 * @sample: Technology Assessment for Android Role
 * @desc NetworkModule is for DI
 * Email Id: mohammadmisbahazmi@gmail.com
 * GitHub: https://github.com/misbahazmi
 * Expertise: Android||Java||Flutter
 */
@Module
class NetworkModule {
    private val REQUEST_TIMEPUT = 10L
    private lateinit var okHttpClinet: OkHttpClient


    @Singleton
    @Provides
    fun provideClient(networkConnectionInterceptor: NetworkConnectionInterceptor) : OkHttpClient{
        val logging= HttpLoggingInterceptor()
        logging.level=if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        okHttpClinet = OkHttpClient.Builder()
            .connectTimeout(REQUEST_TIMEPUT, TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIMEPUT, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .addInterceptor(getHeaderInterceptor())
            .addInterceptor(networkConnectionInterceptor)
            .build()
        return okHttpClinet
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) : APIService{
        return retrofit.create(APIService::class.java)
    }

    /**
     * @author Misbah
     */
    private fun getHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            var request: okhttp3.Request = chain.request()
            val headers = request.headers.newBuilder()
                .add("Accept", "application/json")
                .build()
            request = request.newBuilder().headers(headers).build()
            chain.proceed(request)
        }

    }



}