package com.example.movieapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.MainActivity
import com.example.movieapp.R
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        btnSignUpHandler()
    }

    private fun btnSignUpHandler() {
        btn_signup.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}