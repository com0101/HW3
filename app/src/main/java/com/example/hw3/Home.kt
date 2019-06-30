package com.example.hw3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.hw3.databinding.HomeBinding


class Home : Fragment(){
   // private lateinit var binding: HomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: HomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.home, container, false)
        binding.profilebutton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_home_to_profileEdit)
        }
        return binding.root
    }
}