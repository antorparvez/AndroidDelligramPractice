package com.example.androidpracticedelligram.ui_coordinator_layout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpracticedelligram.databinding.CartRowBinding
import com.example.androidpracticedelligram.ui_constraint_layout.Item

class BottomSheetAdapter(
    val context: CoordinatorLayoutActivity,
    val cartList: ArrayList<Item>
) : RecyclerView.Adapter<BottomSheetAdapter.BottomSheetViewHolder>() {


    inner class BottomSheetViewHolder(var viewBindin: CartRowBinding) :
        RecyclerView.ViewHolder(viewBindin.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetViewHolder {
        val viewBinding = CartRowBinding.inflate(LayoutInflater.from(context), parent, false)
        return BottomSheetViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: BottomSheetViewHolder, position: Int) {
        val cartItem = cartList[position]
        holder.viewBindin.cartRowName.text = cartItem.getName()
        holder.viewBindin.cartRowPrice.text = cartItem.getPrice()
        holder.viewBindin.cartRowImage.setImageResource(cartItem.getImage())


    }

    override fun getItemCount(): Int {
        return cartList.size
    }
}