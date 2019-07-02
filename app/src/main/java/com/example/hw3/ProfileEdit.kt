package com.example.hw3

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.hw3.databinding.ProfileEditBinding

class ProfileEdit:Fragment() {

    private lateinit var binding: ProfileEditBinding
    //private  var content : ContentData = ContentData(0, "","","")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding : ProfileEditBinding=
            DataBindingUtil.inflate(inflater, R.layout.profile_edit, container, false)

        binding.content=content
        val application = requireNotNull(this.activity).application
        val dataSource = ContentDatabase.getInstance(application).contentdao
        val viewModelFactory = ProViewModelFactory(dataSource, application)
        val proViewModel =
          ViewModelProviders.of(
               this, viewModelFactory).get(ProViewModel::class.java)
       // binding.proViewModel =proViewModel
        binding.setLifecycleOwner(this)
       //load()


        binding.savebutton.setOnClickListener { view: View ->
           // save()

        }


        return binding.root
    }
    private fun save(){

            ///val name=  binding.nameText.getText().toString()
            //val nickname =  binding.nicknameText.getText().toString()
           // val aboutyou=  binding.howAboutYouText.getText().toString()

        Toast.makeText(this.context,"saved",Toast.LENGTH_SHORT).show()
    }
    /*private fun load(){
        binding.apply {
            nameText.setText(content?.name)
            nicknameText.setText(content?.nickname )
            howAboutYouText.setText(content?.aboutyou )

        }
    }*/

}