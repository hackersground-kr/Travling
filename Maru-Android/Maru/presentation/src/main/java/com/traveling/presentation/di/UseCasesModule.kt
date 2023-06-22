package com.traveling.presentation.di

import com.traveling.domain.repository.FoodRepository
import com.traveling.domain.usecase.FoodUsecases
import com.traveling.domain.usecase.GetFoods
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Singleton
    @Provides
    fun provideFoodUsecases(foodRepository: FoodRepository) = FoodUsecases(
        GetFoods(foodRepository)
    )
}