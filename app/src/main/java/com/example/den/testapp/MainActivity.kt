package com.example.den.testapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val TAG = "myLog"

    fun toastMe(view: View) {

        // show short toast with text from 'toast_string'
        Toast.makeText(this, R.string.toast_string, Toast.LENGTH_SHORT).show()
    }

    fun countMe(view: View) {

        // Get the value of the text view, convert it to Int and increment
        var count = textView2.text.toString().toInt()
        count++

        // Display the new value in the text view.
        textView2.text = count.toString()
    }

    fun randomMe(view: View) {

        // Create an Intent to start the second activity
        val randomIntent = Intent(this, Main2Activity::class.java)

        // Get the current value of the text view.
        val count = textView2.text.toString().toInt()

        // Add the count to the extras for the Intent.
        randomIntent.putExtra(Main2Activity.TOTAL_COUNT, count)

        // Start the new activity.
        startActivity(randomIntent)
    }

    fun textOnClick(v: View) {
        // по id определяем кнопку, вызвавшую этот обработчик
        Log.d(TAG, "Execute routine depending on pressed button")
        when (v.id) {
            R.id.buttonOk -> tvOut.text = "Нажата Ок"
            R.id.buttonCancel -> tvOut.text = "Нажата Cancel"
        }
    }

}

