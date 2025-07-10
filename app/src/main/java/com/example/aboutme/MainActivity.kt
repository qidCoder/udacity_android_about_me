package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //create databinding object
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
        //replace setContentView with binging
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        findViewById<Button>(R.id.done_button)
//            .setOnClickListener {
//                addNickname(it)
//                //it in this context is the button passed in as view
//            }
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    //function to handle the done button on the click listener
    private fun addNickname(view: View) {
        binding.apply {
            nicknameText.text = binding.nicknameEdit.text
            invalidateAll() //have to add this to refresh the UI with new data
            doneButton.visibility = View.GONE
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        //hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}