package com.traveling.presentation.features.main.food

import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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
        when (viewModel.mode.value) {
            1 -> {
                mBinding.level1.background = resources.getDrawable(R.drawable.level11_button)
                mBinding.level1.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white))
            }
            2 -> {
                mBinding.level2.background = resources.getDrawable(R.drawable.level22_button)
                mBinding.level2.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white))
            }
            3 -> {
                mBinding.level3.background = resources.getDrawable(R.drawable.level33_button)
                mBinding.level3.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white))
            }
        }
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
        adapter = ListFoodAdapter(requireContext(), viewModel.foodList, viewModel) {
                title, content ->
            val action = FoodFragmentDirections.actionFoodFragmentToFoodDetailFragment(title, content, mBinding.title.text.toString(), viewModel.mode.value!!)
            findNavController().navigate(action)
        }
        with(mBinding) {
            rv.adapter = adapter
            rv.layoutManager = GridLayoutManager(context, 2)
        }
    }
}
