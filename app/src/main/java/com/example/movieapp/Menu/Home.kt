package com.example.movieapp.Menu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movieapp.Activity.ComingSoonActivity
import com.example.movieapp.R
import com.example.movieapp.Activity.TopMovieActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSeeMoreComingSoonHandler()
        btnTopMovieHandler()
//        btnProfilePictureHandler()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun btnProfilePictureHandler() {
        profile_pict.setOnClickListener {
            startActivity(Intent(context, Profile::class.java))
        }
    }

    private fun btnSeeMoreComingSoonHandler() {
        btn_see_more_coming_soon.setOnClickListener {
            startActivity(Intent(context, ComingSoonActivity::class.java))
        }
    }

    private fun btnTopMovieHandler() {
        btn_see_more_top_movie.setOnClickListener {
            startActivity(Intent(context, TopMovieActivity::class.java))
        }
    }

}