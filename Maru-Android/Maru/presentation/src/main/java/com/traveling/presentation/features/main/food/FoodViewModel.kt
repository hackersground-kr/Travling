package com.traveling.presentation.features.main.food

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.traveling.domain.model.Food
import com.traveling.domain.usecase.FoodUsecases
import com.traveling.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    private val foodUsecase: FoodUsecases
): BaseViewModel() {
    val foods = MutableLiveData<List<Food>>(arrayListOf())
    val state = MutableLiveData("1")
    val mode =  MutableLiveData(1)

    val foodList = arrayListOf<Food>()

    fun loadFoods(type: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val type = getType(type)
            val idx = state.value.toString()
            foods.postValue(foodUsecase.getFoods(type, idx))
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
        foodList.clear()
        foodList.addAll(foods)
    }
}