package com.traveling.presentation.features.onboard.health

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HealthFragment : BaseFragment<FragmentHealthBinding, HealthViewModel>(), HealthClickListenr {
    override val viewModel: HealthViewModel by viewModels()
    private lateinit var checkList :MutableList<String>
    private val test = mapOf("당뇨" to "dm", "고혈압" to "hbp", "심근경색" to "mi")
    override fun observerViewModel() {
        setinitSpiner()
        setinitDialog()
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

    private fun setinitDialog() {

        mBinding.healthDisease.setOnClickListener {
            checkList = mutableListOf()
            DiseaseDialog(requireContext(), test, this).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = super.onCreateView(inflater, container, savedInstanceState)
        viewModel.loadHealth()
        return v
    }

    private fun setinitSpiner() {
        setIntSpinner(mBinding.healthAge, (1..90).toList())
        setStrSpinner(mBinding.healthBlood, listOf("A", "B", "AB", "O"))
        setIntSpinner(mBinding.healthWeight, (1..90).toList())
        setIntSpinner(mBinding.healthHeight, (30..200).toList())
    }
    private fun setIntSpinner(spinner: AppCompatSpinner, data: List<Int>) {
        val addpter = ArrayAdapter<Int>(requireContext(), R.layout.spinner, data)
        addpter.setDropDownViewResource(R.layout.spinner_selected)
        spinner.adapter = addpter
    }
    private fun setStrSpinner(spinner: AppCompatSpinner, data: List<String>) {
        val addpter = ArrayAdapter<String>(requireContext(), R.layout.spinner, data)
        addpter.setDropDownViewResource(R.layout.spinner_selected)
        spinner.adapter = addpter
    }

    override fun checkBoxCheckChange(name: String, checkBox: CheckBox) {
        Log.d("LOG", "checkBoxCheckChange: ${name}")
        if (checkBox.isChecked) {
            checkList.add(name)
        } else {
            checkList.remove(name)
        }
        mBinding.healthDisease.text = checkList.toString().replace("[", "").replace("]", "")
//        Log.d("LOG", "checkBoxCheckChange: ${checkList.toString().replace("[", "").replace("]", "")}")
    }
}