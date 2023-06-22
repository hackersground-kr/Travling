package com.traveling.presentation.features.lock.screen

import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.traveling.presentation.base.BaseViewModel
import com.traveling.presentation.wiget.MaruApplication
import com.traveling.presentation.wiget.MaruApplication.Companion.prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class ScreenViewModel @Inject constructor()
    : BaseViewModel() {
    var time = MutableLiveData<String>()
    var date = MutableLiveData<String>()
    var work = MutableLiveData<String>()
    var distance = MutableLiveData<String>()
    var calories = MutableLiveData<String>()

    fun loadData() {
        var time: Int = if (MaruApplication.prefs.walkCount == "") { 0 } else {  MaruApplication.prefs.walkCount.toInt()}
        work.postValue(time.toString())
        distance.postValue(calculateDistance(time))
        calories.postValue(calculateCalories(time))
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

    fun getCurrentTime(): String {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        // 시간을 분 단위로 출력
        val times = String.format("%02d:%02d", hour, minute)

        return times
    }
    fun getCurrentDate(): String {
        val calendar = Calendar.getInstance()
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        // 월, 일, 요일을 문자열로 출력
        val weekdays = arrayOf("일", "월", "화", "수", "목", "금", "토")
        val dates = String.format("%d월 %d일 %s요일", month, day, weekdays[dayOfWeek - 1])

        return dates
    }
    fun onClickHeal() {
        viewEvent(ON_CLICK_HEAL)
    }
    fun onClickExit() {
        viewEvent(ON_CLICK_EXIT)
    }

    companion object {
        const val ON_CLICK_HEAL = 0
        const val ON_CLICK_EXIT = 1
    }

}