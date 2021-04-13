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
import com.google.android.material.floatingactionbutton.FloatingActionButton


class RecyclerViewActivity : BaseActivity() {

    lateinit var adpter: RecyclerCustomViewAdapter
    lateinit var recyclerView : RecyclerView
    private lateinit var item: ArrayList<Item>

    lateinit var fab_addItem : FloatingActionButton


    /// For callback Listener
    private val recylerViewCustomViewAdapter by lazy {

        RecyclerCustomViewAdapter(
            item,this,
            {position ->
                onItemUpdate(position)
            }
            ,{
                position ->
                removeValueFromList(position)
            }
        )

    }

    private fun removeValueFromList(position: Int) {

        item.removeAt(position)
        adpter.notifyItemRemoved(position)

    }

    private fun onItemUpdate(position: Int) {
        updateItemValueFromList(position)

    }


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
        //adpter = RecyclerCustomViewAdapter(item, applicationContext ,data)
        adpter = recylerViewCustomViewAdapter
        recyclerView.adapter = adpter



  /*      adpter.itemClickListener(object : AdepterClickListener {
            override fun onItemClick(position: Int, view: View) {
                updateItemValueFromList(position)
            }
        })*/




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

        if (position== -1){

            title.text = "Add New Product"
            name.hint = "Enter Product name"
            price.hint="Enter Product Price"
            offer.hint ="Ender if any offer"
            updateBtn.text = "Add item"

            updateBtn.setOnClickListener {
                item.add(Item("${name.text}", "${price.text}","${offer.text}",R.drawable.sendododine))
                Toast.makeText(applicationContext,"Updated",Toast.LENGTH_SHORT).show()
                adpter.notifyItemChanged(position)
                dialog?.dismiss()


            }
        }else{
            title.text = "Update Product"
            name.setText(item[position].getName())
            price.setText(item[position].getPrice())
            offer.setText(item[position].getOffer())

            updateBtn.setOnClickListener {
                val newItem =  Item("${name.text}", "${price.text}","${offer.text}",R.drawable.sendododine)

                item[position] = newItem
                Toast.makeText(applicationContext,"Updated",Toast.LENGTH_SHORT).show()
                adpter.notifyItemChanged(position)
                dialog?.dismiss()


            }
        }



        cancel.setOnClickListener {
            dialog?.dismiss()
        }


        builder.setView(view)
// create and show the alert dialog
        dialog = builder.create()
        dialog.show()
    }

    private fun initListItem() {

        recyclerView = findViewById(R.id.recyclerView)
        fab_addItem = findViewById(R.id.fab_addItem)

        item = ArrayList()

        fab_addItem.setOnClickListener {

            updateItemValueFromList(-1)


        }

        item.add(Item("THis is a name ", "545","99% off",R.drawable.ic_launcher_foreground))


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