package com.traveling.presentation.features.onboard.health

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.traveling.presentation.R
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentHealthBinding
import com.traveling.presentation.features.main.MainActivity
import com.traveling.presentation.features.onboard.OnBoardActivity
import com.traveling.presentation.features.onboard.health.HealthViewModel.Companion.ON_CLICK_MD
import com.traveling.presentation.features.onboard.health.dialog.DiseaseDialog
import com.traveling.presentation.wiget.MaruApplication
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HealthFragment : BaseFragment<FragmentHealthBinding, HealthViewModel>() {

    val TAG: String = "로그"
    override val viewModel: HealthViewModel by viewModels()

    override fun observerViewModel() {
        viewModel.loadHealth()
//        initSpinner()
        setInitDialog()
        Log.d(TAG, "${viewModel.md1.value} - observerViewModel() called")

        bindingViewEvent {  event ->
            when (event) {
                ON_CLICK_MD -> {
                    if (activity is OnBoardActivity) {
                        findNavController().navigate(R.id.action_healthFragment_to_mdFragment)
                    } else if (activity is MainActivity) {
                        findNavController().popBackStack()
                    }
                }
            }
        }
    }

    private fun setInitDialog() {
        mBinding.healthDisease.setOnClickListener {
            val dialog = DiseaseDialog(requireContext(), viewModel.diseaseMap.value!!, object: OnClickOkListener {
                override fun onClick() {
                    val resultStr = viewModel.diseaseMap.value!!.entries.filter { it.value }
                        .joinToString(",") { it.key }
                    Log.d("로그", "$resultStr - onClick() called")
                    mBinding.healthDisease.text = resultStr
                    MaruApplication.prefs.md1 = resultStr
                }
            })
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }
    }

    /*private fun initSpinner() {
        // TODO 함수로 빼기
        setIntSpinner(mBinding.healthAge, (1..90).toList(),
            object : OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    MaruApplication.prefs.age = (view as? TextView)?.text.toString()
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {}
            })
        setStringSpinner(mBinding.healthBlood, listOf("A", "B", "AB", "O", "RH+", "RH-"),
            object : OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    MaruApplication.prefs.blood = (view as? TextView)?.text.toString()
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {}
            })
        setIntSpinner(mBinding.healthWeight, (1..90).toList(),
            object : OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    MaruApplication.prefs.weight = (view as? TextView)?.text.toString()
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {}
            })
        setIntSpinner(mBinding.healthHeight, (30..200).toList(),
            object : OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    MaruApplication.prefs.height = (view as? TextView)?.text.toString()
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {}
            })
    }

    private fun setIntSpinner(spinner: AppCompatSpinner, data: List<Int>) {
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner, data)
        adapter.setDropDownViewResource(R.layout.spinner_selected)
        spinner.adapter = adapter
    }

    private fun setIntSpinner(spinner: AppCompatSpinner, data: List<Int>, save: OnItemSelectedListener) {
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner, data)
        adapter.setDropDownViewResource(R.layout.spinner_selected)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = save
    }

    private fun setStringSpinner(spinner: AppCompatSpinner, data: List<String>) {
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner, data)
        adapter.setDropDownViewResource(R.layout.spinner_selected)
        spinner.adapter = adapter
    }

    private fun setStringSpinner(spinner: AppCompatSpinner, data: List<String>, save: OnItemSelectedListener) {
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner, data)
        adapter.setDropDownViewResource(R.layout.spinner_selected)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = save
    }*/

    interface OnClickOkListener {
        fun onClick()
    }
}