package com.traveling.presentation.di

import com.traveling.data.repository.FoodRepositoryImpl
import com.traveling.data.service.FoodService
import com.traveling.domain.repository.FoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideFoodRepository(foodService: FoodService): FoodRepository = FoodRepositoryImpl(foodService)
}