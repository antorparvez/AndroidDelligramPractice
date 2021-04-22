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
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.databinding.FragmentSendNotificatonBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SendNotificatonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SendNotificatonFragment() : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val NOTIFICATION_CHANNEL_ID = "my_channel_id_01"
    private var notificationId = 101
    lateinit var viewBinding: FragmentSendNotificatonBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewBinding = FragmentSendNotificatonBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        createNotificationChannel()

        viewBinding.notiSenderTV.text = param1
        viewBinding.sendNotiBtn.setOnClickListener {
            sendNotification()
        }

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


    fun createNotificationChannel() {

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


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SendNotificatonFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SendNotificatonFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }

                Log.d("TAG", "newInstance: $arguments")

            }

    }
}