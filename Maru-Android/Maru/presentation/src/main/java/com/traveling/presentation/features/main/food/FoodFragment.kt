package com.traveling.presentation.features.main.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.traveling.domain.model.Food
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentFoodBinding
import com.traveling.presentation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodFragment : BaseFragment<FragmentFoodBinding, FoodViewModel>() {
    override val viewModel: FoodViewModel by viewModels()

    private lateinit var adapter: ListFoodAdapter

    override fun observerViewModel() {
        with(viewModel) {
            foods.observe(this@FoodFragment) { foods ->
                if (foods != null) {
                    viewModel.addFoods(foods)
                    adapter.notifyItemRangeInserted(0, foods.size)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = super.onCreateView(inflater, container, savedInstanceState)
        initRecyclerView()
        viewModel.loadFoods(mBinding.title.text.toString())
        return v
    }

    private fun initRecyclerView() {
        adapter = ListFoodAdapter(
            listOf(
                Food(1, "s", "1"),
                Food(1, "s", "1"),
                Food(1, "s", "1"),
                Food(1, "s", "1"),
                Food(1, "s", "1"),
                Food(1, "s", "1")
            )
        )
        with(mBinding) {
            rv.layoutManager = GridLayoutManager(requireContext(), 2)
            rv.adapter = adapter
        }
    }
}