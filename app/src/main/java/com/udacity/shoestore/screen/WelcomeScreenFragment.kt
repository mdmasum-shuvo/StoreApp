package com.udacity.shoestore.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeLayoutBinding

class WelcomeScreenFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome_layout, container, false)
        binding.btnNext.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_welcomeScreenFragment_to_instructionFragment)
        )


        return binding.root
    }
}