package com.traveling.domain.parsing

data class news(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)