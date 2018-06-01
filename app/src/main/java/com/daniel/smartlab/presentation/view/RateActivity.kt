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
    var time = 0
    val adapter = RatingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate)
        config()

        ratingsList.layoutManager = LinearLayoutManager(this)
        ratingsList.isNestedScrollingEnabled = false
        ratingsList.adapter = adapter

        adapter.add(presenter.populateRatings())

        fab.setOnClickListener { view ->
            if(presenter.user != null) {
                presenter.save(Rating(
                    dayChooser.indexOfChild(dayChooser.findViewById(dayChooser.checkedRadioButtonId)),
                        time,
                        adapter.ratings,presenter.user!!.id

                ))
            } else {
                Log.d("Login", "Não conseguiu logar")
                Toast.makeText(this,"Algum erro ocorreu", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun login() {
        presenter.login(Settings.Secure.getString(applicationContext.contentResolver,
                Settings.Secure.ANDROID_ID))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_rate, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
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
}
