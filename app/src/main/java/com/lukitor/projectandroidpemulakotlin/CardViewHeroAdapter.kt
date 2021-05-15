package com.lukitor.projectandroidpemulakotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewHeroAdapter(private val listHero: ArrayList<Novel>) : RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val hero = listHero[position]
        holder.photo.setImageResource(hero.foto)
        if (hero.rating == "1") {
            holder.rating.setImageResource(R.drawable.star1)
        }
        else if (hero.rating == "2"){
            holder.rating.setImageResource(R.drawable.star2)
        }
        else if (hero.rating == "3"){
            holder.rating.setImageResource(R.drawable.star3)
        }
        else if (hero.rating == "4"){
            holder.rating.setImageResource(R.drawable.star4)
        }
        else if (hero.rating == "5"){
            holder.rating.setImageResource(R.drawable.star5)
        }
        holder.judul.text = hero.judul
        holder.harga.text = hero.harga

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHero[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photo: ImageView = itemView.findViewById(R.id.gambarcard)
        var judul: TextView = itemView.findViewById(R.id.txtnamacard)
        var harga: TextView = itemView.findViewById(R.id.txthargacard)
        var rating: ImageView = itemView.findViewById(R.id.gambarrating)
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Novel)
    }
}