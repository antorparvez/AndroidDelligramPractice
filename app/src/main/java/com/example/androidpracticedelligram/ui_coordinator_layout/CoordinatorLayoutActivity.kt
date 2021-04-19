package com.example.androidpracticedelligram.ui_coordinator_layout

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.databinding.ActivityCoordinatorLayoutBinding
import com.example.androidpracticedelligram.ui_constraint_layout.Item
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog


class CoordinatorLayoutActivity : AppCompatActivity() {
    
    var list : ArrayList<Item> = ArrayList()
    var cartList : ArrayList<Item> = ArrayList()

    lateinit var viewBinding: ActivityCoordinatorLayoutBinding

     val adapterCoordinatorLT_Adapter: CoordinatorLT_Adapter by lazy {
        CoordinatorLT_Adapter(list)
         { position ,view->
             onItemPositionClick(position,view)
         }
     }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCoordinatorLayoutBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initList()
        initRVAdapter()
        initVal()
    }

    private fun initVal() {

        viewBinding.fabBtn.setOnClickListener {
            fabBtnClick()
        }

    }

    private fun initRVAdapter() {

        viewBinding.coordinatorLTRV.apply {
            layoutManager = GridLayoutManager(
                applicationContext, 2
            )

            viewBinding.coordinatorLTRV.adapter = adapterCoordinatorLT_Adapter
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun onItemPositionClick(position: Int, v: View) {

        //cant change the text here
        v as TextView

        cartList.add(
            Item(
                list[position].getName(),
                list[position].getPrice(),
                list[position].getOffer(),
                list[position].getImage()
            )
        )

        v.text = "Remove form cart"

        Toast.makeText(this,"${cartList.size} item added",Toast.LENGTH_LONG).show()

    }



    private fun fabBtnClick() {

        val dialog = BottomSheetDialog(this)
        val parent : View = layoutInflater.inflate(R.layout.bottom_sheet, null)
        dialog.setContentView(parent)

        val bottomSheetBehavior: BottomSheetBehavior<*> =
            BottomSheetBehavior.from(parent.parent as View)
        bottomSheetBehavior.peekHeight =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100f, resources.displayMetrics)
                .toInt()
        val recyclerView: RecyclerView? =
            dialog.findViewById<View>(R.id.bottomSheetRV) as RecyclerView?


        val adapter = BottomSheetAdapter(this, cartList)
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(
                applicationContext,
                LinearLayoutManager.VERTICAL,
                false
            )

            recyclerView.adapter = adapter
        }

        adapter.notifyDataSetChanged()
        dialog.show()

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
                R.drawable.redbag
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
                R.drawable.redbag
            )
        )

        list.add(
            Item(
                "President Backpack",
                "2999৳",
                "২ পিস কিনলে পাবেন 1 পিস ফ্রি",
                R.drawable.redbag
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

}