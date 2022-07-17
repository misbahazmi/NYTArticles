package com.nytimes.core.data.remote

import com.nytimes.core.data.model.ArticleListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    @GET("mostviewed/{section}/{period}.json")
    suspend fun getArticles( @Path("section") section : String, @Path("period") period : Int, @Query("api-key") apiKey : String): Response<ArticleListResponse>
}