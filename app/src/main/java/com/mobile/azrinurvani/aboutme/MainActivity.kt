package com.mobile.azrinurvani.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.mobile.azrinurvani.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val myName : MyName = MyName("Azri Nurvani")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName
//
//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickName(it)
//        }


        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view:View){
//        val editText = findViewById<EditText>(R.id.edit_name)
//        val nickNameTextView = findViewById<TextView>(R.id.nickname_text)

        binding.apply {
//            nickname_text.text = binding.editName.text
            myName?.nickName = editName.text.toString()
            invalidateAll()
            editName.visibility = View.GONE
            doneButton.visibility = View.GONE
            nickname_text.visibility = View.VISIBLE
        }

//        Hide the Keyboard
        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken,0)
    }
}
