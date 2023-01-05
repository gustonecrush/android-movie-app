package com.example.movieapp.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.BuildConfig
import com.example.movieapp.MainActivity
import com.example.movieapp.R
import com.example.movieapp.Retrofit.Adapter.MovieAdapter
import com.example.movieapp.Retrofit.*
import com.example.movieapp.Retrofit.API.MovieAPI
import com.example.movieapp.Retrofit.Helper.OnMovieClickListener
import kotlinx.android.synthetic.main.activity_coming_soon.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopMovieActivity : AppCompatActivity(), OnMovieClickListener {

    private val list = ArrayList<Results>()
    private val layoutManager: RecyclerView.LayoutManager? = null
    private val adapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_movie)

        getMovies()

        backBtnHandler()
    }

    private fun getMovies() {
        val retro = Retrofit.getRetroData().create(MovieAPI::class.java)
        retro.getMoviesByCategory("popular", BuildConfig.MOVIEDB_API_KEY).enqueue(object:
            Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                response.body()?.results?.let{ list.addAll(it) }
                rv_list_movie.apply {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    adapter = MovieAdapter(list, "popular", true, this@TopMovieActivity)
                }
                Log.d("Movie", "onSuccess: " + response?.body()?.results)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d("Movie", "onFailure: " + t.message)
            }

        })
    }

    private fun backBtnHandler() {
        btn_back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onMovieItemClicked(position: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("id", list[position]?.id)
        intent.putExtra("title", list[position]?.title)
        intent.putExtra("overview", list[position]?.overview)
        intent.putExtra("poster", list[position]?.poster_path)
        intent.putExtra("rating", list[position]?.vote_average)
        startActivity(intent)
    }

}