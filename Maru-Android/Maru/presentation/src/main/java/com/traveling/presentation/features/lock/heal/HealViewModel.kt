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
            name.value = prefs.name
            age.value = prefs.age
            md1.value = prefs.md1
            md2.value = prefs.md2
            md3.value = prefs.md3
            blood.value= prefs.blood
            weight.value = prefs.weight
            height.value = prefs.height
        }
    }
    fun onClickBack() {
        viewEvent(ON_CLICK_BACK)
    }
    companion object {
        const val ON_CLICK_BACK = 0
    }
}