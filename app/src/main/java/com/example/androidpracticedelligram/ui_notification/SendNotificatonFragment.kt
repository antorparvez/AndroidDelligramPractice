package com.example.androidpracticedelligram.ui_notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.databinding.FragmentSendNotificatonBinding
import com.example.androidpracticedelligram.ui_navigation_component.ConfermationFragmentArgs
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging

class SendNotificatonFragment() : Fragment() {

    val NOTIFICATION_CHANNEL_ID = "my_channel_id_01"
    private var notificationId = 101
    lateinit var viewBinding: FragmentSendNotificatonBinding
    lateinit var param1 :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        viewBinding = FragmentSendNotificatonBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        createNotificationChannel()
        val  argument = arguments?.let { SendNotificatonFragmentArgs.fromBundle(it).action }

        viewBinding.notiSenderTV.text = argument
        viewBinding.sendNotiBtn.setOnClickListener {
            sendNotification()
        }


        //Firebase notification TOKEN
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("TAG", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result

            Log.d("tkn ", token.toString())
         //   Toast.makeText(requireContext(), token.toString(), Toast.LENGTH_SHORT).show()
        })

    }

    private fun sendNotification() {
        val bundle = Bundle()
        bundle.putString("param1", "New notification received")

        val pendingIntent = NavDeepLinkBuilder(requireContext())
            .setComponentName(NotificationMainActivity::class.java)
            .setGraph(R.navigation.notification_main_nav)
            .setDestination(R.id.getNotificationFragment)
            .setArguments(bundle)
            .createPendingIntent()




        val builder = NotificationCompat.Builder(requireContext(), NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.redbag)
            .setContentTitle("Notification Practice")
            .setContentText("Something description here")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
        with(context?.let { it1 -> NotificationManagerCompat.from(it1) }) {
            this?.notify(notificationId, builder.build())
        }

    }


    private fun createNotificationChannel() {

        val notificationManager =
            context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(NOTIFICATION_CHANNEL_ID, "Notifications", NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
          //  notificationChannel.lightColor = Color.RED
            notificationChannel.vibrationPattern = longArrayOf(0, 1000, 500, 1000)
            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)
        }

    }

}