package com.traveling.maru.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {
    private val _viewEvent = MutableLiveData<Any>()
    val viewEvent: LiveData<Any>
        get() = _viewEvent

    val tokenErrorEvent = MutableLiveData<String>()

    fun viewEvent(content: Any) {
        _viewEvent.value = content
    }
}