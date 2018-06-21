package com.daniel.smartlab.presentation.view.recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import com.daniel.smartlab.R

class ScheduleHolder (val mView : View, val adapter : ScheduleAdapter)
    : RecyclerView.ViewHolder(mView) {

    lateinit var text : TextView

    init {
        text = this.mView.findViewById(R.id.textView2)
    }
}