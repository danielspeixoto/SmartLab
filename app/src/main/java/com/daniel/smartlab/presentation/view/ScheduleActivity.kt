package com.daniel.smartlab.presentation.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.daniel.smartlab.R
import com.daniel.smartlab.presentation.model.Schedule
import com.daniel.smartlab.presentation.presenter.SchedulePresenter
import com.daniel.smartlab.presentation.view.recycler.ScheduleAdapter

import kotlinx.android.synthetic.main.activity_schedule.*
import kotlinx.android.synthetic.main.content_schedule.*
import org.jetbrains.anko.indeterminateProgressDialog

class ScheduleActivity : AppCompatActivity() {

    var presenter = SchedulePresenter(this)
    val adapter = ScheduleAdapter()
    var day = 0
    val dialog = indeterminateProgressDialog("Carregando...")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        setSupportActionBar(toolbar)

        leftButton.setOnClickListener{ view ->
            day = (day - 1) % 5
            onDayChanged()
        }

        rightButton.setOnClickListener{ view ->
            day = (day + 1) % 5
            onDayChanged()
        }

        fab.setOnClickListener { view ->
            startActivity(Intent(this, RateActivity::class.java))
        }
    }

    fun onError(message : String) {
        showMessage(message)
    }

    fun onLoading() {
        adapter.schedules.clear()
        dialog.show()
    }

    fun onStopLoading() {
        dialog.dismiss()
    }

    fun onScheduleReceived(schedule: Schedule) {
        adapter.schedules.add(schedule)
    }

    fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    val intToDay = hashMapOf<Int, String>(
            0 to "Segunda",
            1 to "Terça",
            2 to "Quarta",
            3 to "Quinta",
            4 to "Sexta"
    )
    fun onDayChanged() {
        dayText.text = intToDay[day]
        presenter.get(day)
    }

}
