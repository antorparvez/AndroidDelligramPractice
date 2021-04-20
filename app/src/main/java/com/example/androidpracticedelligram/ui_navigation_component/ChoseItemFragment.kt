package com.example.androidpracticedelligram.ui_navigation_component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.databinding.FragmentChoseItemBinding


class ChoseItemFragment : Fragment() {
    lateinit var viewBinding: FragmentChoseItemBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        viewBinding =
            FragmentChoseItemBinding.inflate(LayoutInflater.from(context), container, false)

        initListener()

        return viewBinding.root
    }

    private fun initListener() {

        viewBinding.nextBtn.setOnClickListener {


            val action : NavDirections = ChoseItemFragmentDirections.actionChoseItemFragmentToPriceInputFragment(viewBinding.itemNameVC.text.toString(),"")
           Navigation.findNavController(it).navigate(action)
        }
        viewBinding.cancelBtn.setOnClickListener {

            viewBinding.cancelBtn.setOnClickListener {
                Navigation.findNavController(it).navigateUp()
            }
        }

    }

}