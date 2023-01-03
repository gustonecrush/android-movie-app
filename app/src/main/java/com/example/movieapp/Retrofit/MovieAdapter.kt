package com.example.movieapp.Retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.Services.Service
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_land_item.view.*

class MovieAdapter(private val list: ArrayList<Results>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

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
                        tv_date.text  = Service.date(date).toString()

                        Picasso.with(context)
                            .load("https://image.tmdb.org/t/p/original" + backdrop)
                            .resize(700, 380)
                            .into(iv_backdrop);
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_land_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}