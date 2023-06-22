package com.traveling.domain.usecase

import com.traveling.domain.repository.NewsRepository
import javax.inject.Inject

class GetNews(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke() = newsRepository.getNews()
}