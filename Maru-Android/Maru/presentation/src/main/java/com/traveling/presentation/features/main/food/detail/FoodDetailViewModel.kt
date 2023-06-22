package com.traveling.presentation.features.main.food.detail

import androidx.lifecycle.MutableLiveData
import com.traveling.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FoodDetailViewModel @Inject constructor(): BaseViewModel() {
    val title = MutableLiveData<String>()
    val detail = MutableLiveData<String>()
    val md = MutableLiveData<String>()
    val idx = MutableLiveData<Int>()
}