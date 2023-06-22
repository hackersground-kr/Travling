package com.traveling.domain.usecase

import com.traveling.domain.repository.FoodRepository
import javax.inject.Inject

class GetFoods @Inject constructor(
    private val foodRepository: FoodRepository
) {
    suspend operator fun invoke(type: String, idx: String) = foodRepository.getFoods(type, idx)
}