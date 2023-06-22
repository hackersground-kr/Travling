package com.traveling.presentation.features.onboard.health.dialog

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.utils.Utils.init
import com.traveling.presentation.R
import com.traveling.presentation.features.onboard.health.HealthClickListenr


class DiseaseAdapter(
    private var list: List<String>,
    private var clickListenr: HealthClickListenr
): RecyclerView.Adapter<DiseaseAdapter.ViewHolder>()
{
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var checkBox: CheckBox

        init {
            // Define click listener for the ViewHolder's View.
            checkBox = view.findViewById(R.id.disease_checkBox)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_disease, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.checkBox.text = list[position]
        holder.checkBox.setOnCheckedChangeListener { compoundButton, b ->
            clickListenr.checkBoxCheckChange(holder.checkBox.text as String, holder.checkBox)
//            if (holder.checkBox.isChecked) {
//                Log.d("LOG", "onBindViewHolder: ${holder.checkBox.text}")
//                clickListenr.checkBoxCheckChange(holder.checkBox.text as String, holder.checkBox)
//
//            } else {
//                Log.d("LOG", "onBindViewHolder: 체크노")
//            }

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

//    inner class DiseaseItemViewHolder(private val binding: DialogDiseaseBinding) : RecyclerView.ViewHolder(binding.root){
//        fun bind(userItem: String) = with(binding){
//            checkboxUser.isChecked₩ = checkboxStatus[adapterPosition]
//
//            checkboxUser.setOnClickListener {
//                if (!checkboxUser.isChecked)
//                    checkboxStatus.put(adapterPosition, false)
//                else
//                    checkboxStatus.put(adapterPosition, true)
//                notifyItemChanged(adapterPosition)
//            }
//        }
//    }
}

