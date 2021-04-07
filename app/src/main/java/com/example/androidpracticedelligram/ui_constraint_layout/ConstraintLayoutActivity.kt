package com.example.androidpracticedelligram.ui_constraint_layout

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.androidpracticedelligram.BaseActivity
import com.example.androidpracticedelligram.R

class ConstraintLayoutActivity : BaseActivity() {

    lateinit var adapter: CustomAdapter
    var item: ArrayList<Item>? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)
        initToolbar("")


         item = ArrayList()
        item!!.add(Item("সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম","TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস","২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",R.drawable.sendododine))
        item!!.add(Item("সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম","TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস","২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",R.drawable.sendododine))
        item!!.add(Item("সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম","TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস","২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",R.drawable.sendododine))
        item!!.add(Item("সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম","TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস","২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",R.drawable.sendododine))
        item!!.add(Item("সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম","TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস","২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",R.drawable.sendododine))
        item!!.add(Item("সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম","TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস","২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",R.drawable.sendododine))
        item!!.add(Item("সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম","TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস","২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",R.drawable.sendododine))
        item!!.add(Item("সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম","TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস","২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",R.drawable.sendododine))
        item!!.add(Item("সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম","TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস","২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",R.drawable.sendododine))
        item!!.add(Item("সেনসোডাইন টুথপেস্ট ৭৫ গ্রাম","TP টাকা ৳ ১৬৬/পিস MRP ১৭০/পিস","২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি ২৪ পিস কিনলে পাবেন ৬ পিস ফ্রি",R.drawable.sendododine))


        // access the listView from xml file
        var mListView = findViewById<ListView>(R.id.listView)
        adapter = CustomAdapter(this, item!!)
        mListView.adapter = adapter
    }




    class CustomAdapter(private var c: Context, private var item: ArrayList<Item>) : BaseAdapter() {

        override fun getCount(): Int   {  return item.size  }
        override fun getItem(i: Int): Any {  return item[i] }
        override fun getItemId(i: Int): Long { return i.toLong()}

        override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
            var view = view
            if (view == null) {
                //inflate layout resource if its null
                view = LayoutInflater.from(c).inflate(R.layout.order_item, viewGroup, false)
            }

            //get current quote
            val quote = this.getItem(i) as Item

            //reference textviews and imageviews from our layout
            val img = view!!.findViewById(R.id.row_imageView) as ImageView
            val name = view.findViewById(R.id.item_name) as TextView
            val price = view.findViewById(R.id.item_price) as TextView
            val offer = view.findViewById(R.id.item_offer) as TextView

            //BIND data to TextView and ImageVoew
            name.text = quote.getName()
            price.text = quote.getPrice()
            offer.text = quote.getOffer()
            img.setImageResource(quote.getImage())

            //handle itemclicks for the ListView
            view.setOnClickListener { Toast.makeText(c, quote.getName(), Toast.LENGTH_SHORT).show() }

            return view
        }
    }
}