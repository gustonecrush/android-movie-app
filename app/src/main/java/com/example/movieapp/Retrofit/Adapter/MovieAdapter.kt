package com.example.movieapp.Retrofit.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.Retrofit.Helper.OnMovieClickListener
import com.example.movieapp.Retrofit.Results
import com.example.movieapp.Services.Service
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_land_item.view.*

class MovieAdapter(private val list: ArrayList<Results>, private val category: String?, private val activity: Boolean?, private val onMovieClickListener: OnMovieClickListener): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View):
            RecyclerView.ViewHolder(itemView) {
                fun bind(movieResponse: Results) {
                    with(itemView) {
                        // get all data movie
                        val title    = movieResponse.title
                        val backdrop = movieResponse.backdrop_path
                        val poster   = movieResponse.poster_path
                        val date     = movieResponse.release_date

                        tv_title.text = title

                        if(category == "upcoming") {
                            iv_backdrop.visibility = View.VISIBLE
                            iv_poster.visibility   = View.GONE
                            tv_date.text  = Service.date(date).toString()
                            Picasso.with(context)
                                .load("https://image.tmdb.org/t/p/original" + backdrop)
                                .resize(700, 380)
                                .into(iv_backdrop);
                        } else if(category == "popular") {
                            if(activity == true) {
                                iv_poster.visibility   = View.GONE
                                tv_date.text  = Service.date(date).toString()
                                Picasso.with(context)
                                    .load("https://image.tmdb.org/t/p/original" + backdrop)
                                    .resize(700, 380)
                                    .into(iv_backdrop);
                            } else {
                                iv_backdrop.visibility = View.GONE
                                iv_poster.visibility   = View.VISIBLE
                                tv_date.text  = Service.date(date).toString()
                                Picasso.with(context)
                                    .load("https://image.tmdb.org/t/p/original" + poster)
                                    .resize(310, 500)
                                    .into(iv_poster);
                            }
                        }

                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_land_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            onMovieClickListener.onMovieItemClicked(position)
        }
    }

    override fun getItemCount(): Int = list.size

}