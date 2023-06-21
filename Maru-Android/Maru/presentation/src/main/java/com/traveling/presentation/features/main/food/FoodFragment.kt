package com.traveling.presentation.features.main.food

import androidx.fragment.app.viewModels
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentFoodBinding
import com.traveling.presentation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodFragment : BaseFragment<FragmentFoodBinding, FoodViewModel>() {
    override val viewModel: FoodViewModel by viewModels()
    override fun observerViewModel() {

    }
}