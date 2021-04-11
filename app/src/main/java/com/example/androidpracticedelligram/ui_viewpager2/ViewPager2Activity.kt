package com.example.androidpracticedelligram.ui_viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.androidpracticedelligram.BaseActivity
import com.example.androidpracticedelligram.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPager2Activity : BaseActivity() {
    private lateinit var tabLayout : TabLayout
    private lateinit var pager : ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2)
        initToolbar("ViewPager2 with recyclerview Adapter")

        pager = findViewById(R.id.pager)
        tabLayout = findViewById(R.id.viewpager2Tab)

        val words = arrayListOf("Page One", "Page Two", "Page Three")
        pager.adapter = ViewPager2Adapter(this, words)
        TabLayoutMediator(tabLayout, pager) {tab, position ->
            tab.text = "Page ${position + 1}"
        }.attach()


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPager2Activity, "Tab ${tab?.text} selected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPager2Activity, "Tab ${tab?.text} unselected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPager2Activity, "Tab ${tab?.text} reselected", Toast.LENGTH_SHORT).show()
            }
        })

    }
}