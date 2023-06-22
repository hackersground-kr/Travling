package com.traveling.presentation.features.main.food.detail

import android.view.View
import android.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.traveling.presentation.R
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentFoodDetailBinding
import com.traveling.presentation.features.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodDetailFragment : BaseFragment<FragmentFoodDetailBinding, FoodDetailViewModel>() {
    override val viewModel: FoodDetailViewModel by viewModels()
    private val args by navArgs<FoodDetailFragmentArgs>()
    override fun observerViewModel() {
        with(viewModel) {
            title.value = args.title
            detail.value = args.detail
            md.value = args.md
            idx.value = args.idx
        }

        with(mBinding) {
            back.setOnClickListener {
                findNavController().popBackStack()
            }
            when (viewModel.idx.value) {
                1 -> mBinding.main.background = resources.getDrawable(R.color.blue)
                2 -> mBinding.main.background = resources.getDrawable(R.color.yellow)
                3 -> mBinding.main.background = resources.getDrawable(R.color.red)
            }
        }
    }
}