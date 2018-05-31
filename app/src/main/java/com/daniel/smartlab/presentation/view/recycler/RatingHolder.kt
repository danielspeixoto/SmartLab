package com.daniel.smartlab.presentation.view.recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import com.daniel.smartlab.R

class RatingHolder(val mView : View, val adapter : RatingAdapter)
    : RecyclerView.ViewHolder(mView) {

    lateinit var text : TextView
    lateinit var bar : RatingBar

    init {
        text = this.mView.findViewById(R.id.textView2)
        bar = this.mView.findViewById(R.id.ratingBar)
        bar.stepSize = 1f

        bar.setOnRatingBarChangeListener(object : RatingBar.OnRatingBarChangeListener {
            override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
                adapter.setRating(text.text.toString(), rating.toInt())
            }
        })
    }
}