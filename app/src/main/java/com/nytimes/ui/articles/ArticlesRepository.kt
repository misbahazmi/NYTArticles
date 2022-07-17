package com.nytimes.ui.articles


import com.nytimes.core.data.remote.RemoteDataSource
import com.nytimes.core.data.resultLiveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Named

/**
 * @author: MOHAMMAD MISBAH
 * @since: 16-Jul-2022
 * @sample: Technology Assessment for Android Role
 * @desc ArticlesRepository to make network operations
 * Email Id: mohammadmisbahazmi@gmail.com
 * GitHub: https://github.com/misbahazmi
 * Expertise: Android||Java||Flutter
 */
open class ArticlesRepository (val remoteDataSource: RemoteDataSource, @Named("IO") private val io: CoroutineDispatcher = Dispatchers.IO){

    open fun observeArticles(section : String, period: Int) = resultLiveData(
        networkCall = { remoteDataSource.getArticles(section, period) },
        io = io
    )
}