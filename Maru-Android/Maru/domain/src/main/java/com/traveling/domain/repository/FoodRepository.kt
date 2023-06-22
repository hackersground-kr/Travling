package com.traveling.domain.repository

import com.traveling.domain.model.Food

interface FoodRepository {
    suspend fun getFoods(type: String, idx: String): List<Food>
}