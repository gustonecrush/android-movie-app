package com.example.movieapp.Retrofit.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.Retrofit.Cast
import com.example.movieapp.Retrofit.CreditResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_cast.view.*

class CastAdapter(private val list: ArrayList<Cast>): RecyclerView.Adapter<CastAdapter.CastViewHolder>() {

    inner class CastViewHolder(itemView: View):
            RecyclerView.ViewHolder(itemView) {
                fun bind(castResponse: Cast) {
                    with(itemView) {
                        val name      = castResponse.name
                        val character = castResponse.character
                        val profile   = castResponse.profile_path

                        tv_name.text = name
                        tv_character.text = character

                        Picasso.with(context)
                            .load("https://image.tmdb.org/t/p/original" + profile)
                            .fit()
                            .centerCrop()
                            .into(iv_profile)
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cast, parent, false)
        return CastViewHolder(view)
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}