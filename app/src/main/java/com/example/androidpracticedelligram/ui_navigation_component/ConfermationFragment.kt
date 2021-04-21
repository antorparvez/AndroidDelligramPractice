package com.example.androidpracticedelligram.ui_navigation_component

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.databinding.FragmentConfermationBinding


class ConfermationFragment : Fragment() {

    lateinit var viewBinding: FragmentConfermationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        //viewBinding = FragmentConfermationBinding.inflate(LayoutInflater.from(context),container,false)
        viewBinding = FragmentConfermationBinding.inflate(layoutInflater)

        intiLintener()

        return viewBinding.root}

    private fun intiLintener() {


        val  a = arguments?.let { ConfermationFragmentArgs.fromBundle(it).name }
        val  b = arguments?.let { ConfermationFragmentArgs.fromBundle(it).amount}

        viewBinding.amount.text=a
        viewBinding.name.text=b



    }

}