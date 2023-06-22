package com.traveling.presentation.features.main.food

import android.util.Log
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

    init {
        state.value = "1"
        foods.value = arrayListOf()
    }

    val foodList = arrayListOf<Food>()

    fun loadFoods(type: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val type = getType(type)
            val idx = state.value.toString()
            Log.d("로그", "${type} :: ${idx} - loadFoods() called")
            val a = foodUsecase.getFoods(type, idx)
            for (i in a) {
                Log.d("로그", "$i - loadFoods() called")
            }
            foods.postValue(a)
        }
    }

    private fun getType(str: String): String {
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