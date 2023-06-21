package com.traveling.presentation.features.main.news

import androidx.fragment.app.viewModels
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentHomeBinding
import com.traveling.presentation.databinding.FragmentNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding, NewsViewModel>() {
    override val viewModel: NewsViewModel by viewModels()
    override fun observerViewModel() {

    }
}