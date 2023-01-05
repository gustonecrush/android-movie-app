package com.example.movieapp.Fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.Retrofit.Adapter.MovieAdapter
import com.example.movieapp.BuildConfig
import com.example.movieapp.Activity.DetailActivity
import com.example.movieapp.R
import com.example.movieapp.Retrofit.*
import com.example.movieapp.Retrofit.API.MovieAPI
import com.example.movieapp.Retrofit.Helper.OnMovieClickListener
import kotlinx.android.synthetic.main.fragment_top_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopMoviesFragment : Fragment(), OnMovieClickListener {

    private val list = ArrayList<Results>()
    private val layoutManager: RecyclerView.LayoutManager? = null
    private val adapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMovies()
    }

    private fun getMovies() {
        val retro = Retrofit.getRetroData().create(MovieAPI::class.java)
        retro.getMoviesByCategory("popular", BuildConfig.MOVIEDB_API_KEY).enqueue(object:
            Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                response.body()?.results?.let{ list.addAll(it) }
                rv_top_movies.apply {
                    layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                    adapter = MovieAdapter(list, "popular", false, this@TopMoviesFragment)
                }
                Log.d("Movie", "onSuccess: " + response?.body()?.results)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d("Movie", "onFailure: " + t.message)
            }

        })
    }

    override fun onMovieItemClicked(position: Int) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("id", list[position]?.id)
        intent.putExtra("title", list[position]?.title)
        intent.putExtra("overview", list[position]?.overview)
        intent.putExtra("poster", list[position]?.poster_path)
        intent.putExtra("rating", list[position]?.vote_average)
        startActivity(intent)
    }

}