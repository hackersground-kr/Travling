package com.traveling.presentation.features.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.traveling.presentation.base.BaseViewModel
import com.traveling.presentation.wiget.MaruApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

): BaseViewModel() {
    val setting = MutableLiveData<Boolean>()
    var work = MutableLiveData<String>()
    var distance = MutableLiveData<String>()
    var calories = MutableLiveData<String>()

    fun loadData() {
        var time: Int = if (MaruApplication.prefs.walkCount == "") { 0 } else {  MaruApplication.prefs.walkCount.toInt()}
        work.postValue(time.toString())
        distance.postValue(calculateDistance(time))
        calories.postValue(calculateCalories(time))
    }

    fun startWalk() {
        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                work.postValue(MaruApplication.prefs.walkCount)
                delay(2000)
            }
        }
    }

    fun calculateDistance(steps: Int): String {
        // 걸음 수에 따른 이동 거리 계산 (1만걸음 = 5킬로미터)
        val distance = steps.toDouble() / 10000 * 5
        return "${"%.2f".format(distance)}km"
    }

    fun calculateCalories(steps: Int): String {
        // 걸음 수에 따른 소모 칼로리 계산 (1만걸음당 300칼로리)
        val calories = (steps.toDouble() / 10000 * 300).toInt()
        return "${calories}kcal"
    }
    fun onClickFood() {
        viewEvent(ON_CLICK_FOOD)
    }

    fun onClickProfile() {
        viewEvent(ON_CLICK_PROFILE)
    }

    fun onClickWalk() {
        viewEvent(ON_CLICK_WALK)
    }

    fun onClickAlarm() {
        viewEvent(ON_CLICK_ALARM)
    }

    fun onClickNews() {
        viewEvent(ON_CLICK_NEWS)
    }

    companion object {
        const val ON_CLICK_FOOD = 0
        const val ON_CLICK_PROFILE = 1
        const val ON_CLICK_WALK = 2
        const val ON_CLICK_ALARM = 3
        const val ON_CLICK_NEWS = 4
    }
}
