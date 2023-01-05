package com.example.movieapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.BuildConfig
import com.example.movieapp.MainActivity
import com.example.movieapp.R
import com.example.movieapp.Retrofit.Adapter.MovieAdapter
import com.example.movieapp.Retrofit.*
import com.example.movieapp.Retrofit.API.MovieAPI
import com.example.movieapp.Retrofit.Adapter.CastAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    private val list = ArrayList<Cast>()
    private val layoutManager: RecyclerView.LayoutManager? = null
    private val adapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // getting intent data when item clicked in every section
        val id       = intent.getIntExtra("id", 0)
        val title    = intent.getStringExtra("title")
        val overview = intent.getStringExtra("overview")
        val poster   = intent.getStringExtra("poster")
        val rating   = intent.getFloatExtra("rating", 0f)
        
        // setting rating in rating bar
        rating_bar.rating = rating / 2

        // setting title in text view
        tv_title.text = title

        // setting genre in text view
        tv_category.text = "Sci-Fiction"

        // setting overview in text view
        tv_overview.text = overview

        // setting poster in image view
        Picasso.with(this)
            .load("https://image.tmdb.org/t/p/original" + poster)
            .fit()
            .centerCrop()
            .into(iv_poster)

        // fetching data credits to show movie's casts in detail activity
        getCredits(id)

        btnBackHandler()
    }

    private fun getCredits(id: Int?) {
        val retro = Retrofit.getRetroData().create(MovieAPI::class.java)
        retro.getMovieCredits(id, BuildConfig.MOVIEDB_API_KEY).enqueue(object:
            Callback<CreditResponse> {
            override fun onResponse(call: Call<CreditResponse>, response: Response<CreditResponse>) {
                response.body()?.cast?.let{ list.addAll(it) }
                rv_cast.apply {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = CastAdapter(list)
                }
                Log.d("Cast", "onSuccess: " + response?.body()?.cast)
            }

            override fun onFailure(call: Call<CreditResponse>, t: Throwable) {
                Log.d("Cast", "onFailure: " + t.message)
            }
        })
    }

    private fun btnBackHandler() {
        btn_back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}