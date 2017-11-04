package com.example.den.testapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast


class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private val myTAG = "myLog"

    fun showToast(view: View) {

        // show short toast with text from 'toast_string'
        toast(R.string.toast_string)
    }

    fun countMe(view: View) {

        // get the value of the text view, convert it to Int and increment
        var count = textView2.text.toString().toInt()
        count++

        // display the new value in the text view.
        textView2.text = count.toString()
    }

    fun randomMe(view: View) {

        // create an Intent to start the second activity
        val randomIntent = Intent(this, Two::class.java)

        // get the current value of the text view.
        val count = textView2.text.toString().toInt()

        // add the count to the extras for the Intent.
        randomIntent.putExtra(Two.TOTAL_COUNT, count)

        // start the new activity.
        startActivity(randomIntent)
    }

    fun textOnClick(v: View) {
        // put log event so we can trace it later
        Log.d(myTAG, "Execute routine depending on pressed button")

        // execute routine depending on the id of a pressed button
        when (v.id) {
            R.id.buttonOk -> tvOut.text = getText(R.string.msgOk)
            R.id.buttonCancel -> tvOut.text = getText(R.string.msgCn)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menu.add("menu1")
        menu.add("menu2")
        menu.add("menu3")
        menu.add("menu4")

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        toast(item.title)
        return super.onOptionsItemSelected(item)
    }

}

