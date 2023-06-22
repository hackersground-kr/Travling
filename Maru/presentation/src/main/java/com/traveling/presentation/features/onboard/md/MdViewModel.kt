package com.traveling.presentation.features.onboard.md

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.traveling.presentation.base.BaseViewModel
import com.traveling.presentation.wiget.MaruApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MdViewModel @Inject constructor(

): BaseViewModel() {
    var day11 = MutableLiveData<String>()
    var day12 = MutableLiveData<String>()
    var day21 = MutableLiveData<String>()
    var day22 = MutableLiveData<String>()
    var day31 = MutableLiveData<String>()
    var day32 = MutableLiveData<String>()

    fun onClickComplete() {
        try {
            if (!isHour(day11.value!!) || !isMinute(day12.value!!) ||
                !isHour(day21.value!!) || !isMinute(day22.value!!) ||
                !isHour(day31.value!!) || !isMinute(day32.value!!)) {
            }
        } catch (e: Exception) {
            viewEvent(RETRY)
            Log.d("로그", "MdViewModel - onClickComplete() called")
            return
        }

        with(MaruApplication) {
            prefs.day11 = day11.value!!
            prefs.day12 = day12.value!!
            prefs.day21 = day21.value!!
            prefs.day22 = day22.value!!
            prefs.day31 = day31.value!!
            prefs.day32 = day32.value!!
        }
        viewEvent(ON_CLICK_COMPLETE)
    }

    private fun isHour(str: String) = str.toInt() in 0..23 || str == ""
    private fun isMinute(str: String) = str.toInt() in 0..59 || str == ""

    companion object {
        const val ON_CLICK_COMPLETE = 0
        const val RETRY = 1
    }
}