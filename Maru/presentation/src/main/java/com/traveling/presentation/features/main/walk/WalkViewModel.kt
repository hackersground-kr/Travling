package com.traveling.presentation.features.main.walk

import androidx.lifecycle.MutableLiveData
import com.traveling.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WalkViewModel @Inject constructor(

): BaseViewModel() {
    val walkCount = MutableLiveData<String>()


}