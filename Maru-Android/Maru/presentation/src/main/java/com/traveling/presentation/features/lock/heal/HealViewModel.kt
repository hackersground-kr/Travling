package com.traveling.presentation.features.lock.heal

import androidx.lifecycle.MutableLiveData
import com.traveling.presentation.base.BaseViewModel
import com.traveling.presentation.wiget.MaruApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HealViewModel @Inject constructor()
    : BaseViewModel() {
    val name = MutableLiveData<String>()
    val age = MutableLiveData<String>()
    val md1 = MutableLiveData<String>()
    val md2 = MutableLiveData<String>()
    val md3 = MutableLiveData<String>()
    val blood = MutableLiveData<String>()
    val weight = MutableLiveData<String>()
    val height = MutableLiveData<String>()

    fun loadHeal() {
        with(MaruApplication) {
            name.value = "이름 : ${prefs.name}"
            age.value = "나이 : 만 ${prefs.age} 세"
            md1.value = "의학적 질환 : ${prefs.md1}"
            md2.value = "의료 기록 : ${prefs.md2}"
            md3.value = "알레르기 : ${prefs.md3}"
            blood.value= "혈액형 : ${prefs.blood}형"
            weight.value = "체중 : ${prefs.weight} kg"
            height.value = "신장 : ${prefs.height} kg"
        }
    }
    fun onClickBack() {
        viewEvent(ON_CLICK_BACK)
    }
    companion object {
        const val ON_CLICK_BACK = 0
    }
}