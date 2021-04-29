package com.example.androidpracticedelligram.ui_notification

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.databinding.ActivityNotificationMainBinding


class NotificationMainActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityNotificationMainBinding
    lateinit var notiController: NavController
    var navArg : String = "none"
     private val notifiactionArguments:Bundle  = Bundle()
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

        val bundle = intent.extras
        if (bundle != null) {
            //bundle contains all info of "data" field of the notification
            Log.d("TAG", "onStart: ${bundle["msg"]}")
            navArg = intent.getStringExtra("msg").toString()

        }


       //  val bundle2 = Bundle()
       // bundle2.putString("click_action",navArg)
        //navController.setGraph(navController.graph,bundle)

        notiController = findNavController(R.id.noti_host)
        notiController.setGraph(notiController.graph,SendNotificatonFragmentArgs(navArg).toBundle())
            //  viewBinding..setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, notiController)


    }

    override fun onSupportNavigateUp(): Boolean {

        return notiController.navigateUp()
    }


}