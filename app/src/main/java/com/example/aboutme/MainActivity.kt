package com.example.aboutme

import android.content.Context
import android.hardware.input.InputManager
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        binding.nicknameText.text = binding.nicknameEdit.text
//        nicknameTextView.text = editText.text
        binding.doneButton.visibility = View.GONE
//        view.visibility = View.GONE
        binding.nicknameEdit.visibility = View.GONE
//        editText.visibility = View.GONE
        binding.nicknameText.visibility = View.VISIBLE
//        nicknameTextView.visibility = View.VISIBLE

        //hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}