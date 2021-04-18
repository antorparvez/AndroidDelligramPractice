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

     var list: ArrayList<String> = ArrayList()
     var list2: ArrayList<String> = ArrayList()
    lateinit var recyclerView: RecyclerView
    lateinit var adpter: ReyclerViewPaginationAdapter
    lateinit var addBtn: Button
    lateinit var noItems: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyeler_v_iew_pagination)

        initToolbar("Pagination on Recyclerview")
        //initVals()

        addBtn = findViewById(R.id.addBtn)
        noItems = findViewById(R.id.no_itemTV)

        recyclerView = findViewById(R.id.paginationRV)




        recyclerView.apply {
            layoutManager = LinearLayoutManager(
                applicationContext,
                LinearLayoutManager.VERTICAL,
                false
            )
            adpter = ReyclerViewPaginationAdapter(list2)
            //adpter = recylerViewCustomViewAdapter
            adapter = adpter
        }





        addBtn.setOnClickListener {

            for ( i in 0..10){
                list2.add("row item = $i")
                Log.d("TAG", "onCreate: $i")
            }

            Log.d("TAG", "onCreate: ${list2.size}")
            adpter.notifyDataSetChanged()


        }
    }

    private fun initVals() {
/*
        list = ArrayList()
        list2 = ArrayList()*/
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