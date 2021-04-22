package com.example.androidpracticedelligram.ui_notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.databinding.ActivityNavigationMainBinding
import com.example.androidpracticedelligram.databinding.ActivityNotificationMainBinding
import com.example.androidpracticedelligram.ui_naviagation_bottom_nav.HomeFragment

class NotificationMainActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityNotificationMainBinding
    lateinit var notiController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityNotificationMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initVal()
        initNavControler()
    }

    private fun initVal() {
    // SendNotificatonFragment.newInstance("antorparvez@deligram.com","antorparvez@gmail.com")

        val args = Bundle()
        args.putString("param1", "Antor")
        val homeFrag = SendNotificatonFragment()
        homeFrag.arguments = args



    }

    private fun initNavControler() {

        notiController = findNavController(R.id.noti_host)
            //  viewBinding..setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, notiController)


    }
}