package com.example.androidpracticedelligram.ui_recylerview

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.EditText
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

    }


    private fun initListItem() {

        recyclerView = findViewById(R.id.recyclerView)

        item = ArrayList()
        item.add(
            Item(
                "সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম",
                "TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস",
                "২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",
                R.drawable.sendododine
            )
        )
        item.add(
            Item(
                "সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম",
                "TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস",
                "২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",
                R.drawable.sendododine
            )
        )
        item.add(
            Item(
                "সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম",
                "TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস",
                "২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",
                R.drawable.sendododine
            )
        )
        item.add(
            Item(
                "সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম",
                "TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস",
                "২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",
                R.drawable.sendododine
            )
        )
        item.add(
            Item(
                "সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম",
                "TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস",
                "২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",
                R.drawable.sendododine
            )
        )
        item.add(
            Item(
                "সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম",
                "TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস",
                "২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",
                R.drawable.sendododine
            )
        )
        item.add(
            Item(
                "সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম",
                "TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস",
                "২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",
                R.drawable.sendododine
            )
        )
        item.add(
            Item(
                "সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম",
                "TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস",
                "২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",
                R.drawable.sendododine
            )
        )
        item.add(
            Item(
                "সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম",
                "TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস",
                "২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",
                R.drawable.sendododine
            )
        )
        item.add(
            Item(
                "সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম",
                "TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস",
                "২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",
                R.drawable.sendododine
            )
        )


    }
}