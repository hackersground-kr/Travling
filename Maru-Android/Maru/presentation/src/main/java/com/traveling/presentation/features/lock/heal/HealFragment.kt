package com.traveling.presentation.features.lock.heal

import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentHealBinding

class HealFragment: BaseFragment<FragmentHealBinding, HealViewModel>() {
    override val viewModel: HealViewModel by viewModels()
    val name = MutableLiveData<String>()
    val age = MutableLiveData<String>()
    val call = MutableLiveData<String>()
    val md1 = MutableLiveData<String>()
    val md2 = MutableLiveData<String>()
    val md3 = MutableLiveData<String>()
    val blood = MutableLiveData<String>()
    val weight = MutableLiveData<String>()
    val height = MutableLiveData<String>()
    override fun observerViewModel() {

    }
}