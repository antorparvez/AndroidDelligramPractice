package com.example.androidpracticedelligram.ui_coordinator_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.databinding.ActivityCoordinatorLayoutBinding
import com.example.androidpracticedelligram.ui_constraint_layout.Item

class CoordinatorLayoutActivity : AppCompatActivity() {
    
    var list : ArrayList<Item> = ArrayList()
    
     val adapterCoordinatorLT_Adapter: CoordinatorLT_Adapter by lazy {
        CoordinatorLT_Adapter(list)
         {
             position ->
             onItemPositionClick(position )
     }
     }

    private fun onItemPositionClick(position: Int) {


    }


    lateinit var viewBinding: ActivityCoordinatorLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCoordinatorLayoutBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initList()
        initRVAdapter()
    }

    private fun initList() {

        list.add(
            Item(
                "President Backpack",
                "2999৳",
                "২ পিস কিনলে পাবেন 1 পিস ফ্রি",
                R.drawable.bluebag
            )
        )
        list.add(
            Item(
                "President Backpack",
                "2999৳",
                "২ পিস কিনলে পাবেন 1 পিস ফ্রি",
                R.drawable.bluebag
            )
        )
        list.add(
            Item(
                "President Backpack",
                "2999৳",
                "২ পিস কিনলে পাবেন 1 পিস ফ্রি",
                R.drawable.bluebag
            )
        )

    }

    private fun initRVAdapter() {

        viewBinding.coordinatorLTRV.apply {
            layoutManager = GridLayoutManager(
                applicationContext,2
            )

            viewBinding.coordinatorLTRV.adapter = adapterCoordinatorLT_Adapter
        }


    }
}