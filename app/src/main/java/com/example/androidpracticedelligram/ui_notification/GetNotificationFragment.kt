package com.example.androidpracticedelligram.ui_notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.databinding.FragmentGetNotificationBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GetNotificationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GetNotificationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var viewBinding:FragmentGetNotificationBinding

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
       // return inflater.inflate(R.layout.fragment_get_notification, container, false)
        viewBinding = FragmentGetNotificationBinding.inflate(layoutInflater)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.getNotiTV.text = param1

        /*{
            "message":{
            "token" : "cw9Zz0fVSaiVmE1A5-BsMI:APA91bG_i-WXt00ihPV4HhgMv3Ph2hK7YjHalu0WjAqHMghk2pe2Jm2soLY1YuA26tTFWccx7EvwYbJNs638FQ0_xcmFi20Sytc5PaqgYU6DlAb5yS5hlosIHOR6jEFFOrHwxVgYa1",
            "android": {
            "notification": {
            "body" : "This is an FCM notification that displays an image.!",
            "title" : "FCM Notification",
            "image": "url-to-image"
        }
        }
        }
        }*/

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GetNotificationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GetNotificationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}