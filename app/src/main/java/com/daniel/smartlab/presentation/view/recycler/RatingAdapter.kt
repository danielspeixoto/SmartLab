package com.daniel.smartlab.presentation.view.recycler

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class RatingAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var types : List<String> = listOf()

    fun getRatings() : HashMap<String, Int> {
        return hashMapOf()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RatingHolder()
    }

    override fun getItemCount(): Int {
        return types.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun add(populateRatings: List<String>) {

    }
}