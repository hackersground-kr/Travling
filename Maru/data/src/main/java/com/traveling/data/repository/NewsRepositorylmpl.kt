package com.traveling.data.repository

import com.traveling.data.service.NewService
import com.traveling.domain.model.Food
import com.traveling.domain.parsing.news
import com.traveling.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositorylmpl @Inject constructor(
    private var newService: NewService
): NewsRepository {
    override suspend fun getNews(): news {
        return newService.getNews()
    }

}