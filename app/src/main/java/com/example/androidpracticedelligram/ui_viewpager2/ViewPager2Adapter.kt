package com.example.androidpracticedelligram.ui_viewpager2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpracticedelligram.R

class ViewPager2Adapter(private val context: Context, private val words: List<String>): RecyclerView.Adapter<ViewPager2Adapter.PageHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder {
       val view :View =  LayoutInflater.from(context).inflate(R.layout.view_pager2_item,parent,false)
        return PageHolder(view)
    }

    override fun onBindViewHolder(holder: PageHolder, position: Int) {
        holder.textView.text = words[position]
    }

    override fun getItemCount(): Int {
       return words.size
    }




    inner class PageHolder(view: View): RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.viewpagerTV)
    }


}