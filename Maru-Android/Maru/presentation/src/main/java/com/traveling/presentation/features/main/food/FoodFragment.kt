package com.traveling.presentation.features.main.food

import android.util.Log
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.traveling.presentation.R
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentFoodBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodFragment : BaseFragment<FragmentFoodBinding, FoodViewModel>() {
    override val viewModel: FoodViewModel by viewModels()

    private lateinit var adapter: ListFoodAdapter

    override fun observerViewModel() {
        with(viewModel) {
            foods.observe(this@FoodFragment) { foods ->
                if (foods != null) {
                    for (i in foods) {
                        Log.d("로그", "$i - observerViewModel() called")
                    }
                    viewModel.addFoods(foods)
                    adapter.notifyItemRangeInserted(0, foods.size)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadFoods(mBinding.title.text.toString())
        initRecyclerView()
        with(mBinding) {
            level1.setOnClickListener {
                reload()
                level1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.blue))
                level1.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white))
                viewModel.state.value = "1"
            }
            level2.setOnClickListener {
                reload()
                level2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.yellow))
                level1.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white))
                viewModel.state.value = "2"


            }
            level3.setOnClickListener {
                reload()
                level3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.red))
                level1.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white))
                viewModel.state.value = "3"

            }
        }
    }

    private fun reload() {
        with(mBinding) {
            level1.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.gray))
            level2.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.gray))
            level3.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.gray))
            level1.setBackgroundResource(R.drawable.level1_button)
            level2.setBackgroundResource(R.drawable.level2_button)
            level3.setBackgroundResource(R.drawable.level3_button)
        }
    }

    private fun initRecyclerView() {
        adapter = ListFoodAdapter(viewModel.foodList)
        with(mBinding) {
            rv.adapter = adapter
            rv.layoutManager = GridLayoutManager(context, 2)
        }
    }
}