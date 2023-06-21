package com.traveling.presentation.features.main.food.detail

import androidx.fragment.app.viewModels
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentFoodDetailBinding

class FoodDetailFragment : BaseFragment<FragmentFoodDetailBinding, FoodDetailViewModel>() {
    override val viewModel: FoodDetailViewModel by viewModels()
    override fun observerViewModel() {

    }
}