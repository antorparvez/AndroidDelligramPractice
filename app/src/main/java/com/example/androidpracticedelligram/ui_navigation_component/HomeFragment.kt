package com.example.androidpracticedelligram.ui_navigation_component

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var viewBindin: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBindin = FragmentHomeBinding.inflate(LayoutInflater.from(context),container,false)

        initLintener()

        return viewBindin.root
    }

    private fun initLintener() {
        viewBindin.viewListBtn.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_viewTansactionFragment)

        }


        viewBindin.viewResult.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_viewResultFragment)
        }


        viewBindin.valueInput.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_choseItemFragment)
        }

    }

}