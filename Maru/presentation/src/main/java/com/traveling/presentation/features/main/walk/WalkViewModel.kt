package com.traveling.presentation.features.main.walk

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
class WalkViewModel @Inject constructor(

): BaseViewModel() {
    val walkCount = MutableLiveData("0")
    val kcal = MutableLiveData("0kcal")

    fun startWalk() {
        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                walkCount.postValue(MaruApplication.prefs.walkCount + "")
                kcal.postValue(((walkCount.value!!.toDouble() / 10000 * 300).toInt()).toString() + "kcal")
                delay(2000)
            }
        }
    }
}