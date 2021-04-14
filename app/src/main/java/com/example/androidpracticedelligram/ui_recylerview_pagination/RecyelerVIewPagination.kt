package com.example.androidpracticedelligram.ui_recylerview_pagination

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpracticedelligram.BaseActivity
import com.example.androidpracticedelligram.R

class RecyelerVIewPagination : BaseActivity(){

    lateinit var list: java.util.ArrayList<String>
    lateinit var list2: java.util.ArrayList<String>
    lateinit var recyclerView: RecyclerView
    lateinit var adpter: ReyclerViewPaginationAdapter
    lateinit var addBtn: Button
    lateinit var noItems: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyeler_v_iew_pagination)

        initToolbar("Pagination on Recyclerview")
        initVals()



        recyclerView = findViewById(R.id.paginationRV)

        recyclerView.layoutManager = LinearLayoutManager(
            applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )
        adpter = ReyclerViewPaginationAdapter(list2)
        //adpter = recylerViewCustomViewAdapter
        recyclerView.adapter = adpter




        addBtn.setOnClickListener {
            var i = 0
            if (list2.size <= list.size) {
                noItems.visibility = View.GONE
                list2.add(list[i])
                list2.add(list[i + 1])
                list2.add(list[i + 2])
                i += 2
                Log.d("TAG", "onCreate: " + list2.size)
            } else {
                Toast.makeText(applicationContext, "no item on list", Toast.LENGTH_SHORT).show()
            }
            adpter.notifyDataSetChanged()


        }
    }

    private fun initVals() {

        list = ArrayList()
        list2 = ArrayList()
        addBtn = findViewById(R.id.addBtn)
        noItems = findViewById(R.id.no_itemTV)


        list.add(" Left side view")
        list.add("Right side view")
        list.add(" Left side view")
        list.add("Right side view")
        list.add(" Left side view")
        list.add(" Left side view")
        list.add("Right side view")
        list.add(" Left side view")
        list.add("Right side view")
        list.add(" Left side view")
        list.add(" Left side view")
        list.add("Right side view")
        list.add(" Left side view")
        list.add("Right side view")
        list.add(" Left side view")

    }
}