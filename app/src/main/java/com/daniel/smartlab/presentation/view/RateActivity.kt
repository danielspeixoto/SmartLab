package com.daniel.smartlab.presentation.view

import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SeekBar
import android.widget.Toast
import com.daniel.smartlab.R
import com.daniel.smartlab.presentation.model.Rating
import com.daniel.smartlab.presentation.presenter.RatePresenter
import com.daniel.smartlab.presentation.view.helper.timeChooser
import com.daniel.smartlab.presentation.view.recycler.RatingAdapter
import dagger.android.AndroidInjection

import kotlinx.android.synthetic.main.activity_rate.*
import kotlinx.android.synthetic.main.content_rate.*
import javax.inject.Inject

class RateActivity : AppCompatActivity() {

    var presenter = RatePresenter(this)
    var time = 1
    val adapter = RatingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate)
        config()
        login()

        ratingsList.layoutManager = LinearLayoutManager(this)
        ratingsList.isNestedScrollingEnabled = false
        ratingsList.adapter = adapter

        adapter.add(presenter.populateRatings())

        fab.setOnClickListener { view ->
            if(adapter.ratings.size == 0) {
                Toast.makeText(this,"Preencha pelo menos uma avaliacao", Toast.LENGTH_LONG).show()
            } else if(presenter.user == null) {
                Log.d("Login", "Não conseguiu logar")
                Toast.makeText(this,"Tente Novamente", Toast.LENGTH_LONG).show()
            } else {
                presenter.save(Rating(
                    dayChooser.indexOfChild(dayChooser.findViewById(dayChooser.checkedRadioButtonId)),
                        time,
                        adapter.ratings,
                        presenter.user!!.id

                ))
            }
        }
    }

    fun login() {
        presenter.login(Settings.Secure.getString(applicationContext.contentResolver,
                Settings.Secure.ANDROID_ID))
    }

    fun config() {
        timeSeek.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                time = progress
                timeText.setText(timeChooser(progress))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }

    fun showMessage(text  : String) {
        Toast.makeText(this,text, Toast.LENGTH_LONG).show()
    }
}
