package com.example.androidpracticedelligram.ui_recylerview

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpracticedelligram.BaseActivity
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.ui_constraint_layout.Item


class RecyclerViewActivity : BaseActivity() {

    lateinit var adpter: RecyclerCustomViewAdapter
    lateinit var recyclerView : RecyclerView
    private lateinit var item: ArrayList<Item>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        initToolbar("Recycler view")

        initListItem()

        recyclerView.layoutManager = LinearLayoutManager(
            applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )
        adpter = RecyclerCustomViewAdapter(item, applicationContext)
        recyclerView.adapter = adpter



        adpter.itemClickListener(object : AdepterClickListener {
            override fun onItemClick(position: Int, view: View) {
                updateItemValueFromList(position)
            }
        })




    }

    private fun updateItemValueFromList(position: Int) {
        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(this)
// set the custom layout
        val view = layoutInflater.inflate(R.layout.custom_dialog,null)
// Get Views references from your layout
        val title: TextView = view.findViewById(R.id.dialog_title)
        val name: EditText = view.findViewById(R.id.et_productName)
        val price: EditText = view.findViewById(R.id.et_productPrice)
        val offer: EditText = view.findViewById(R.id.et_productOffer)
        val updateBtn: Button = view.findViewById(R.id.updateBtn)
        val cancel: Button = view.findViewById(R.id.cancelBtn)

        title.text = "Update Product"
        name.setText(item[position].getName())
        price.setText(item[position].getPrice())
        offer.setText(item[position].getOffer())

        cancel.setOnClickListener {
            dialog?.dismiss()
        }

        updateBtn.setOnClickListener {
           val newItem =  Item("${name.text}", "${price.text}","${offer.text}",R.drawable.sendododine)

            item[position] = newItem
            Toast.makeText(applicationContext,"Updated",Toast.LENGTH_SHORT).show()
            adpter.notifyDataSetChanged()
            dialog?.dismiss()


        }

        builder.setView(view)
// create and show the alert dialog
        dialog = builder.create()
        dialog.show()
    }

    private fun initListItem() {

        recyclerView = findViewById(R.id.recyclerView)

        item = ArrayList()
        item.add(
            Item(
                "সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম",
                "TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস",
                "২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",
                R.drawable.sendododine
            )
        )
        item.add(
            Item(
                "সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম",
                "TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস",
                "২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",
                R.drawable.sendododine
            )
        )
        item.add(
            Item(
                "সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম",
                "TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস",
                "২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",
                R.drawable.sendododine
            )
        )
        item.add(
            Item(
                "সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম",
                "TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস",
                "২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",
                R.drawable.sendododine
            )
        )



    }
}