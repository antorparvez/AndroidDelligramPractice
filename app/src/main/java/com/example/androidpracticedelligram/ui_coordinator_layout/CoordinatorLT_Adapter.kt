package com.example.androidpracticedelligram.ui_coordinator_layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpracticedelligram.databinding.SingleCartItemBinding
import com.example.androidpracticedelligram.ui_constraint_layout.Item

class CoordinatorLT_Adapter(
    private val cartList: ArrayList<Item>,
    private val onItemPositionClick: (position: Int,view:View) -> Unit,
): RecyclerView.Adapter<CoordinatorLT_Adapter.CartViewHolder>() {

    lateinit var  binding : SingleCartItemBinding



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        binding = SingleCartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        //binding= SingleCartItemBinding.inflate(LayoutInflater.from(parent.context))
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartList[position]
        holder.binding.cartItemName.text = item.getName()
        holder.binding.cartItemOffer.text = item.getOffer()
        holder.binding.rowImageView.setImageResource(item.getImage())
        holder.binding.cartItemPrice.text = item.getPrice()

    }

    override fun getItemCount(): Int {
        return cartList.size
    }




    //View holder inner class
    inner  class CartViewHolder(val binding: SingleCartItemBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.cartBtn.setOnClickListener {
                onItemPositionClick(adapterPosition,binding.cartBtn)
            }
        }
    }



}