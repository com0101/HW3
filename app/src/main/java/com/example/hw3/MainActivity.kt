package com.example.hw3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.hw3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        //up-nav(backstack)
        val navController = this.findNavController(R.id.NavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        //savebutton

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.NavHostFragment)
        return navController.navigateUp()
    }

  /*  private fun applytext(view: View){
        val editText = findViewById<EditText>(R.id.name_text)
        val textView = findViewById<TextView>(R.id.nametextView)
        //val editText2 = findViewById<EditText>(R.id.nickname_text)
        //val editText3 = findViewById<EditText>(R.id.how_about_you_text)
        textView.text = editText.text
        editText.visibility = View.GONE
       //view.visibility = View.GONE
       textView.visibility = View.VISIBLE
        // Hide the keyboard.
       /* val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)*/

    }*/

}
