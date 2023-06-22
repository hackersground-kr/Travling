package com.traveling.presentation.features.main.food

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.traveling.domain.model.Food
import com.traveling.domain.usecase.FoodUsecases
import com.traveling.presentation.base.BaseViewModel
import com.traveling.presentation.wiget.MaruApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    private val foodUsecase: FoodUsecases
): BaseViewModel() {
    val foods = MutableLiveData<List<Food>>(arrayListOf())
    val state = MutableLiveData("1")
    val md = MutableLiveData<String>("당뇨")

    val foodList = arrayListOf<Food>()

    fun loadFoods(type: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val type = getType(type)
            val idx = state.value.toString()
            foods.postValue(foodUsecase.getFoods(type, idx))
        }
    }

    fun onClickMd() {
        viewEvent(ON_CLICK_MD)
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

    fun removeFoods() {
        foodList.clear()
    }

    companion object {
        const val ON_CLICK_MD = 0
    }
}