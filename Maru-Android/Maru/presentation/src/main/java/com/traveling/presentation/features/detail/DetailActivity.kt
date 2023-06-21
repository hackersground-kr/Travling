package com.traveling.presentation.features.detail

import androidx.activity.viewModels
import com.traveling.presentation.base.BaseActivity
import com.traveling.presentation.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {
    override val viewModel: DetailViewModel by viewModels()
    override fun observerViewModel() {

    }
}