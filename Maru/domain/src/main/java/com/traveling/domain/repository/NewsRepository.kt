package com.traveling.domain.repository

import com.traveling.domain.parsing.news

interface NewsRepository {
    suspend fun getNews(): news
}