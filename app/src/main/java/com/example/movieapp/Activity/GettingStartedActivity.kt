package com.example.movieapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.MainActivity
import com.example.movieapp.R
import kotlinx.android.synthetic.main.activity_getting_started.*

class GettingStartedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getting_started)

        btnGettingStartedHandler()
    }

    private fun btnGettingStartedHandler() {
        btn_getting_started.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}