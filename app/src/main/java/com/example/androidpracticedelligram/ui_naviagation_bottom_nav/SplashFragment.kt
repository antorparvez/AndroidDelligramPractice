package com.example.androidpracticedelligram.ui_naviagation_bottom_nav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.databinding.FragmentSplashBinding
import com.example.androidpracticedelligram.ui_naviagation_bottom_nav.utils.AsyncData


/**
 * A simple [Fragment] subclass.
 * Use the [SplashFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SplashFragment : Fragment() {

    lateinit var viewBinding:FragmentSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_splash, container, false)

        viewBinding = FragmentSplashBinding.inflate(layoutInflater)

        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //Get value from singleton class
        val value : String = AsyncData.dataClass.name

        viewBinding.nameSplash.text = value

    }

}