package com.traveling.presentation.di

import com.traveling.data.repository.FoodRepositoryImpl
import com.traveling.data.repository.NewsRepositorylmpl
import com.traveling.data.service.FoodService
import com.traveling.data.service.NewService
import com.traveling.domain.repository.FoodRepository
import com.traveling.domain.repository.NewsRepository
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

    @Singleton
    @Provides
    fun provideNewsRepository(newsService: NewService): NewsRepository = NewsRepositorylmpl(newsService)
}