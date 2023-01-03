package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.Retrofit.*
import kotlinx.android.synthetic.main.activity_coming_soon.*
import kotlinx.android.synthetic.main.fragment_coming_soon.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ComingSoonActivity : AppCompatActivity() {

    private val list = ArrayList<Results>()
    private val layoutManager: RecyclerView.LayoutManager? = null
    private val adapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coming_soon)

        getMovies()
    }

    private fun getMovies() {
        val retro = Retrofit.getRetroData().create(MovieAPI::class.java)
        retro.getMoviesByCategory("upcoming", BuildConfig.MOVIEDB_API_KEY).enqueue(object: Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                response.body()?.results?.let{ list.addAll(it) }
                rv_coming_soon_act.apply {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    adapter = MovieAdapter(list)
                }
                Log.d("Movie", "onSuccess: " + response?.body()?.results)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d("Movie", "onFailure: " + t.message)
            }

        })
    }
}