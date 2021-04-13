package com.example.androidpracticedelligram.ui_recylerview_pagination

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpracticedelligram.R

class ReyclerViewPaginationAdapter(val list: List<String>) :
    RecyclerView.Adapter<ReyclerViewPaginationAdapter.ViewHolder> (){

    private val LAYOUT_LEFT = 0
    private val LAYOUT_RIGHT = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       /* val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_right, parent, false)
         return ViewHolder(view)*/

        val view: View = if(viewType==LAYOUT_LEFT) {
            LayoutInflater.from(parent.context).inflate(R.layout.item_left, parent, false);

        } else {
            LayoutInflater.from(parent.context).inflate(R.layout.item_right, parent, false);

        }

        return ViewHolder(view)

    }

    override fun getItemViewType(position: Int): Int {
        return if(position % 2 ==0 )
            LAYOUT_LEFT;
        else
            LAYOUT_RIGHT;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item_left_right_tv.text = "$position ${list[position ]} "
    }

    override fun getItemCount(): Int {
        return list.size
    }



    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val item_left_right_tv : TextView = itemView.findViewById(R.id.item_left_right_tv)

    }
}