package com.example.androidpracticedelligram.ui_navigation_component

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.androidpracticedelligram.databinding.FragmentPriceInputBinding


class PriceInputFragment : Fragment() {

    lateinit var viewBinding: FragmentPriceInputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewBinding =
            FragmentPriceInputBinding.inflate(LayoutInflater.from(context), container, false)

        initListener()

        return viewBinding.root
    }

    private fun initListener() {

        viewBinding.nextBtn.setOnClickListener {
            // for navaigation
           /* Navigation.findNavController(it)
                .navigate(R.id.action_priceInputFragment_to_confermationFragment)*/
            val name = arguments?.let { it1 -> PriceInputFragmentArgs.fromBundle(it1).sendAmount }

            val action : NavDirections = PriceInputFragmentDirections.actionPriceInputFragmentToConfermationFragment(name!!,viewBinding.itemPrice.text.toString())

            Navigation.findNavController(it).navigate(action)

        }
        viewBinding.cancelBtn.setOnClickListener {

            // this.findNavController().popBackStack()
            Navigation.findNavController(it).navigateUp()
        }
    }

}