package com.traveling.presentation.features.main.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.traveling.domain.model.Food
import com.traveling.domain.parsing.Article
import com.traveling.domain.usecase.GetNews
import com.traveling.domain.usecase.NewsUsecases
import com.traveling.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class NewsViewModel @Inject constructor(
    private var newsUsecases: NewsUsecases
): BaseViewModel() {
    val news = MutableLiveData<List<Article>>(arrayListOf())
    val newsList = ArrayList<Article>()
    fun loadNews(){
        viewModelScope.launch(Dispatchers.IO) {
            val s = newsUsecases.getNews()
            if (s.status != "ok") {
                return@launch
            }
            news.value = s.articles
        }
    }
}