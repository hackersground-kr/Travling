package com.traveling.presentation.features.onboard.health

import androidx.lifecycle.MutableLiveData
import com.traveling.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HealthViewModel @Inject constructor(

): BaseViewModel() {

    val name = MutableLiveData<String>()
    val age = MutableLiveData<String>()
    val md1 = MutableLiveData<String>()
    val md2 = MutableLiveData<String>()
    val md3 = MutableLiveData<String>()
    val blood = MutableLiveData<String>()
    val weight = MutableLiveData<String>()
    val height = MutableLiveData<String>()

    fun onClickMd() {
        viewEvent(ON_CLICK_MD)
    }

    companion object {
        const val ON_CLICK_MD = 0
    }
}