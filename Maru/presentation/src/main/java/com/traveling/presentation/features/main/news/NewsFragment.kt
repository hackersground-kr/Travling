package com.traveling.presentation.features.main.news

import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentNewsBinding
import com.traveling.presentation.features.main.food.FoodFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding, NewsViewModel>() {
    override val viewModel: NewsViewModel by viewModels()

    private lateinit var adapter: ListNewsAdapter
    override fun observerViewModel() {
        initRecyclerView()

    }
    private fun initRecyclerView() {
        adapter = ListNewsAdapter(requireContext(), viewModel.newsList, viewModel)
        with(mBinding) {
            newsRv.adapter = adapter
            newsRv.layoutManager = LinearLayoutManager(context)
        }
    }
}