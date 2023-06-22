package com.traveling.data.service

import com.traveling.domain.model.Food
import retrofit2.http.GET
import retrofit2.http.Path

interface FoodService {
    @GET("food/{type}/{idx}")
    suspend fun getFoods(
        @Path("type") type: String,
        @Path("idx") idx: String
    ): List<Food>
}