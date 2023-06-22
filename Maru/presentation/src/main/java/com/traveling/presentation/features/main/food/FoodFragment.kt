package com.traveling.presentation.features.main.food

import android.util.Log
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.traveling.domain.model.Food
import com.traveling.presentation.R
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentFoodBinding
import com.traveling.presentation.features.main.food.FoodViewModel.Companion.ON_CLICK_MD
import com.traveling.presentation.features.main.food.dialog.MdDialog
import com.traveling.presentation.util.Constants.TAG
import com.traveling.presentation.wiget.MaruApplication
import dagger.hilt.android.AndroidEntryPoint

/**
 * 해커톤 코드 :fire:
 * 이 코드는 많이 더럽습니다.
 * 주의하세용
 */

@AndroidEntryPoint
class FoodFragment : BaseFragment<FragmentFoodBinding, FoodViewModel>() {
    override val viewModel: FoodViewModel by viewModels()

    private lateinit var adapter: ListFoodAdapter

    override fun observerViewModel() {
        bindingViewEvent { event ->
            when (event) {
                ON_CLICK_MD -> {
                    val dialog = MdDialog(requireContext(), viewModel) {
                        mBinding.title.text = viewModel.md.value
                        viewModel.loadFoods(viewModel.md.value.toString())
                    }
                    dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                    dialog.setCancelable(false)
                    dialog.show()
                }
            }
        }
        with(viewModel) {
            foods.observe(this@FoodFragment) { foods ->
                if (foods != null) {
                    foods.forEach { _ ->
                        Log.d(TAG, "FoodFragment - observerViewModel() called")
                    }
                    reloadFoods(foods)
                }
            }
        }
    }
    private fun reloadFoods(foods: List<Food>) {
        val len = viewModel.foodList.size
        viewModel.addFoods(foods)
        if (len == 0) {
            viewModel.addFoods(foods)
            adapter.notifyItemRangeInserted(0, viewModel.foodList.size)
        } else {
            viewModel.removeFoods()
            adapter.notifyItemRangeRemoved(0, len)
            viewModel.addFoods(foods)
            adapter.notifyItemRangeInserted(0, foods.size)
        }
    }

    private fun initOnClickListener() {
        with(mBinding) {
            level1.setOnClickListener {
                viewModel.state.value = "1"
                reload()
                level1.background = resources.getDrawable(R.drawable.level11_button)
                level1.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white))
            }
            level2.setOnClickListener {
                viewModel.state.value = "2"
                reload()
                level2.background = resources.getDrawable(R.drawable.level22_button)
                level2.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white))
            }
            level3.setOnClickListener {
                viewModel.state.value = "3"
                reload()
                level3.background = resources.getDrawable(R.drawable.level33_button)
                level3.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white))
            }
        }
    }

    private fun initOnClickMode() {
        when (viewModel.state.value) {
            "1" -> {
                mBinding.level1.background = resources.getDrawable(R.drawable.level11_button)
                mBinding.level1.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white))
            }
            "2" -> {
                mBinding.level2.background = resources.getDrawable(R.drawable.level22_button)
                mBinding.level2.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white))
            }
            "3" -> {
                mBinding.level3.background = resources.getDrawable(R.drawable.level33_button)
                mBinding.level3.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white))
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val dr = MaruApplication.prefs.md1
        val first= dr.split(",")[0]
        if (dr != "") {
            viewModel.md.value = first
            reload()
        } else {
            viewModel.md.value = "당뇨"
            reload()
        }
        initRecyclerView()
        initOnClickListener()
        initOnClickMode()
        initTitle()
        Log.d(TAG, "${mBinding.title.text} - onStart() called")
        viewModel.loadFoods(mBinding.title.text.toString())
    }

    private fun initTitle() {
        mBinding.title.text = viewModel.md.value
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
            val action = FoodFragmentDirections.actionFoodFragmentToFoodDetailFragment(title, content, mBinding.title.text.toString(), viewModel.state.value!!)
            findNavController().navigate(action)
        }
        with(mBinding) {
            rv.adapter = adapter
            rv.layoutManager = GridLayoutManager(context, 2)
        }
    }
}
