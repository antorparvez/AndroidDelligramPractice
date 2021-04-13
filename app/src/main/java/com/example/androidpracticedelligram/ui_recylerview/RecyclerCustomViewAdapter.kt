package com.example.androidpracticedelligram.ui_recylerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.ui_constraint_layout.Item

class RecyclerCustomViewAdapter(
    private val itemList: List<Item>, private val mContext: Context,
    /// For callback Listener
    private val onItemUpdate: (position: Int) -> Unit,
    private val onItemRemove: (position: Int) -> Unit): RecyclerView.Adapter<RecyclerCustomViewAdapter.CustomViewHolder>() {

    lateinit var listener: AdepterClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView: View
            if (viewType == 2) {
              itemView=  LayoutInflater.from(mContext).inflate(R.layout.recylerview_item, parent, false)
            }else{
               itemView=  LayoutInflater.from(mContext).inflate(R.layout.order_item, parent, false)
            }
        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item = itemList[position]

        holder.itemName.text = item.getName()
        holder.itemPrice.text = item.getPrice()
        holder.itemOffer.text = item.getOffer()
        holder.item_count_value.text = "23"

        holder.item_count_minus.setOnClickListener {
            holder.item_count_value.text = "sadf"
        }

    }

    private fun updateValue(toString: String) {

        Toast.makeText(mContext, "$toString", Toast.LENGTH_SHORT)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }


    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        val editItem: TextView = itemView.findViewById(R.id.editItem)
        val itemName: TextView = itemView.findViewById(R.id.item_name)
        val itemPrice: TextView = itemView.findViewById(R.id.item_price)
        val itemOffer: TextView = itemView.findViewById(R.id.item_offer)
        val item_count_minus: TextView = itemView.findViewById(R.id.item_count_minus)
        val item_count_value: TextView = itemView.findViewById(R.id.item_count_value)
        val item_count_plus: TextView = itemView.findViewById(R.id.item_count_plus)
        val removeItem: TextView = itemView.findViewById(R.id.removeItem)


        init {
            //editItem.setOnClickListener(this)
            /// For callback Listener
            editItem.setOnClickListener {
                onItemUpdate(adapterPosition)

            }
            /// For callback Listener
            removeItem.setOnClickListener {
                onItemRemove(adapterPosition)
            }

        }


        override fun onClick(v: View?) {
            if (v != null) {
                listener.onItemClick(adapterPosition, v)
            }

        }

    }

    fun itemClickListener(listener: AdepterClickListener) {
        this.listener = listener

    }

    private fun getStringInBangla(string: String): String? {
        val banglaNumber = arrayOf('০', '১', '২', '৩', '৪', '৫', '৬', '৭', '৮', '৯')
        val engNumber = arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
        val values = StringBuilder()
        val character = string.toCharArray()
        for (value in character) {
            var c = ' '
            for (j in engNumber.indices) {
                if (value == engNumber[j]) {
                    c = banglaNumber[j]
                    break
                } else {
                    c = value
                }
            }
            values.append(c)
        }
        return values.toString()
    }

}