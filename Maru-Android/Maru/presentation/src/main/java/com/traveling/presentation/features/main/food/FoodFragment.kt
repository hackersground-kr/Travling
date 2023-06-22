package com.traveling.presentation.features.main.food

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
                    viewModel.addFoods(foods)
                    adapter.notifyDataSetChanged()
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
                viewModel.state.value = "1"
                viewModel.mode.value = 1
                reload()
                level1.background = resources.getDrawable(R.drawable.level11_button)
                level1.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white))
            }
            level2.setOnClickListener {
                viewModel.mode.value = 2
                viewModel.state.value = "2"
                reload()
                level2.background = resources.getDrawable(R.drawable.level22_button)
                level2.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white))
            }
            level3.setOnClickListener {
                viewModel.mode.value = 3
                viewModel.state.value = "3"
                reload()
                level3.background = resources.getDrawable(R.drawable.level33_button)
                level3.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white))
            }
        }
    }

    private fun reload() {
        viewModel.loadFoods(mBinding.title.text.toString())
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
        adapter = ListFoodAdapter(requireContext(), viewModel.foodList, mBinding.title.text.toString(), viewModel)
        with(mBinding) {
            rv.adapter = adapter
            rv.layoutManager = GridLayoutManager(context, 2)
        }
    }
}
