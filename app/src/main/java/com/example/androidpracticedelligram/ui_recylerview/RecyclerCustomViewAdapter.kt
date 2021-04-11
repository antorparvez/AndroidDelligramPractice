package com.example.androidpracticedelligram.ui_recylerview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpracticedelligram.ui_constraint_layout.Item

class RecyclerCustomViewAdapter (val itemList: List<Item>,mContext: Context) :
    RecyclerView.Adapter<RecyclerCustomViewAdapter.CustomViewHolder>() {
    lateinit var listiner : AdepterClickListiner


   inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            if (v != null){
                listiner.onItemClick(adapterPosition,v)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


    fun itemClick(listiner2: AdepterClickListiner){

        listiner = listiner2

    }

}