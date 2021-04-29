package com.example.androidpracticedelligram.ui_notification

import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavDeepLinkBuilder
import com.example.androidpracticedelligram.R
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FireBaseService : FirebaseMessagingService() {
    val TAG = "PushNotifService"
    lateinit var name: String

    val NOTIFICATION_CHANNEL_ID = "my_channel_id_01"
    val notificationId = 101


    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
        val p = p0.data

        Log.d(TAG, "onMessageReceived: ${p["msg"]}")
        Log.d(TAG, "onNotificationReceived: ${p0.notification!!.title}")

        val bundle = Bundle()
       // bundle.putString("param1", p0.data["msg"] +"\n New notification received")
        bundle.putString("param1", p0.notification!!.title +"\n New notification received")

        showNotification(bundle)


    }


   fun showNotification(bundle: Bundle) {
       val pendingIntent = NavDeepLinkBuilder(this)
           .setComponentName(NotificationMainActivity::class.java)
           .setGraph(R.navigation.notification_main_nav)
           .setDestination(R.id.getNotificationFragment)
           .setArguments(bundle)
           .createPendingIntent()


       val builder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
           .setSmallIcon(R.drawable.redbag)
           .setAutoCancel(true)
           .setContentTitle("Notification Practice")
           .setContentText("Something description here")
           .setPriority(NotificationCompat.PRIORITY_DEFAULT)
           .setContentIntent(pendingIntent)
       with(this.let { it1 -> NotificationManagerCompat.from(it1) }) {
           this.notify(notificationId, builder.build())
       }
    }


}