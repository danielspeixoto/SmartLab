package com.daniel.smartlab.presentation.view.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.daniel.smartlab.R
import com.daniel.smartlab.presentation.model.Schedule

class ScheduleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var schedules : ArrayList<Schedule> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ScheduleHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.schedule_item, parent,
                        false),
                this)
    }

    override fun getItemCount(): Int {
        return schedules.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ScheduleHolder
        holder.text.text = schedules[position].time.toString() + ":00 - " +
                (schedules[position].time + 1).toString() + ":00"
    }
}