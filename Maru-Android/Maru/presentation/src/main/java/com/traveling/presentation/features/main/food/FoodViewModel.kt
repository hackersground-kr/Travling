package com.traveling.presentation.features.main.food

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.traveling.domain.model.Food
import com.traveling.domain.usecase.FoodUsecases
import com.traveling.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    private val foodUsecase: FoodUsecases
): BaseViewModel() {
    val foods = MutableLiveData<List<Food>>()
    val state = MutableLiveData<String>()

    private val foodList = arrayListOf<Food>()

    fun loadFoods(type: String) {
        viewModelScope.launch(Dispatchers.IO) {
             foods.value = foodUsecase.getFoods(type, getIdx(state.value!!))
        }
    }

    private fun getIdx(str: String): String {
        if (str == "당뇨") {
            return "dm"
        } else if (str == "심근경색") {
            return "mi"
        } else {
            return "hbp"
        }
    }

    fun addFoods(foods: List<Food>) {
        foodList.addAll(foods)
    }
}