package com.daniel.smartlab.presentation.view.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.daniel.smartlab.R

class RatingAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var types : List<String> = listOf()
    var ratings = hashMapOf<String, Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RatingHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.rating_item, parent,
                        false),
                this)

    }

    override fun getItemCount(): Int {
        return types.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as RatingHolder
        holder.text.text = types[position]
    }

    fun add(populateRatings: List<String>) {
        types = populateRatings
    }

    fun setRating(text: String, toInt: Int) {
        ratings[text] = toInt
    }
}