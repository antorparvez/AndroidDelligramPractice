package com.example.androidpracticedelligram.ui_naviagation_bottom_nav

import android.R.id
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.databinding.ActivityBottomNavMainBinding
import com.example.androidpracticedelligram.ui_naviagation_bottom_nav.utils.AsyncData


class BottomNavMainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    lateinit var viewBinding: ActivityBottomNavMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //val ("name2", 32) = DataClass;

        viewBinding = ActivityBottomNavMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // put value to singleton class
        AsyncData.dataClass.name = "name: Antor"
        AsyncData.dataClass.age = 27


        HomeFragment.newInstance("This is Pram1", "This is Pram2")


        val homeFrag = HomeFragment()
        val args = Bundle()
        args.putString("param1", "Antor")
        homeFrag.arguments = args

        navController = findNavController(R.id.nav_container)
        viewBinding.bottomNav.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}
