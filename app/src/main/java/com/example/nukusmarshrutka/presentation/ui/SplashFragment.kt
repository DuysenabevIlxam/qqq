package com.example.nukusmarshrutka.presentation.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nukusmarshrutka.R
import com.example.nukusmarshrutka.databinding.FragmentSplashBinding
import kotlin.random.Random

class SplashFragment: Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val randomNum = Random.nextLong(1000, 2000)

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }, randomNum)
    }
}