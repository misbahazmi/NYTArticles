package com.nytimes.core.data.remote

import com.nytimes.BuildConfig
import com.nytimes.core.base.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: APIService) : BaseDataSource(){

    suspend fun getArticles(section : String, period: Int) = getResults {
        apiService.getArticles( section, period, BuildConfig.API_KEY);
    }
}