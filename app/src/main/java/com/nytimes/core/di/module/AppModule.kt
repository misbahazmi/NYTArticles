package com.nytimes.core.di.module

import android.app.Application
import android.content.Context
import com.nytimes.NYTApplication
import com.nytimes.core.data.remote.APIService
import com.nytimes.core.data.remote.RemoteDataSource
import com.nytimes.core.di.NetworkConnectionInterceptor
import com.nytimes.utils.Utils
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author: MOHAMMAD MISBAH
 * @since: 16-Jul-2022
 * @sample: Technology Assessment for Android Role
 * @desc AppModule is for DI
 * Email Id: mohammadmisbahazmi@gmail.com
 * GitHub: https://github.com/misbahazmi
 * Expertise: Android||Java||Flutter
 */
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: NYTApplication): Context = application

    @Provides
    @Singleton
    fun provideApplication(app: NYTApplication): Application = app

    @Singleton
    @Provides
    fun provideGson() = Gson()

    @Singleton
    @Provides
    fun provideUtils(context: Context) = Utils(context = context)

    @Provides
    @Singleton
    @Named("DEFAULT")
    fun provideDefaultDispatchers(): CoroutineDispatcher =
        Dispatchers.Default

    @Provides
    @Singleton
    @Named("IO")
    fun provideBackgroundDispatchers(): CoroutineDispatcher =
        Dispatchers.IO

    @Provides
    @Singleton
    @Named("MAIN")
    fun provideMainDispatchers(): CoroutineDispatcher =
        Dispatchers.Main

    @Provides
    @Singleton
    fun provideNetworkConnectionInterceptor(utils: Utils) = NetworkConnectionInterceptor(utils)

    @Provides
    @Singleton
    fun provideRemoteDataSource(apiService: APIService) = RemoteDataSource(apiService)
}