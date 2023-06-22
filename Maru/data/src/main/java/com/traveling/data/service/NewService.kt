package com.traveling.data.service

import com.traveling.domain.parsing.news
import com.traveling.domain.model.Response
import retrofit2.http.GET

interface NewService {
    @GET("/news")
    suspend fun getNews(
    ): news
}