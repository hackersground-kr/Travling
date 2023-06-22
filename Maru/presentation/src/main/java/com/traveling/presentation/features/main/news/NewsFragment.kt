package com.traveling.presentation.features.main.news

import android.app.Activity
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentNewsBinding
import com.traveling.presentation.features.main.food.FoodFragmentDirections
import com.traveling.presentation.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding, NewsViewModel>() {
    override val viewModel: NewsViewModel by viewModels()
    private lateinit var adapter: NewsAdapter
    override fun observerViewModel() {
        with(viewModel) {
            news.observe(this@NewsFragment) { news ->
                if (news != null) {
                    news.forEach { _ ->
                        Log.d(Constants.TAG, "FoodFragment - observerViewModel() called")
                    }
                    initRecyclerView()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadNews()
//        initRecyclerView()

    }
    private fun initRecyclerView() {
        adapter = NewsAdapter(viewModel.newsList, Activity())
        with(mBinding) {
            newsRv.adapter = adapter
            newsRv.layoutManager = LinearLayoutManager(context)
        }
    }

}