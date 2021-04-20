package com.example.androidpracticedelligram.ui_navigation_component

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.R.*


class NavigationMainActivity : AppCompatActivity() {
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_navigation_main)

      initNavigationControler()
    }

    private fun initNavigationControler() {
        //navController = Navigation.findNavController(this,R.id.nav_host_fragment).navigateUp()

        navController = findNavController(id.fragment_container)
        NavigationUI.setupActionBarWithNavController(this, navController)


    }

   /* override fun onSupportNavigateUp(): Boolean {
        return (Navigation.findNavController(this, id.homeFragment).navigateUp()
                || super.onSupportNavigateUp())
    }*/



    //override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment).navigateUp()


}