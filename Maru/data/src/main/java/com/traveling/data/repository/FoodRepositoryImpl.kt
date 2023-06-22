package com.traveling.data.repository

import com.traveling.data.service.FoodService
import com.traveling.domain.model.Food
import com.traveling.domain.repository.FoodRepository
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val foodService: FoodService
): FoodRepository {
    override suspend fun getFoods(type: String, idx: String): List<Food> = foodService.getFoods(type, idx).items
}