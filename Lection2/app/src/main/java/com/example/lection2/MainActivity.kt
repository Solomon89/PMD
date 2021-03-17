package com.example.lection2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var countButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        countButton = findViewById(R.id.random_button)
    }
    fun toastMe(view: View) {
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Привет ИБС!", Toast.LENGTH_LONG)
        myToast.show()
    }

    fun randomMe(view: View)
    {
        val randomIntent = Intent(this, SecondActivity::class.java)
        val countString = textView.text.toString()
        val count = Integer.parseInt(countString)
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)
        randomIntent.putExtra(SecondActivity.Button_Name, "Рандом")
        startActivity(randomIntent)
    }


    fun countMe (view: View) {
        // Get the value of the text view.
        val countString = textView.text.toString()
        // Convert value to a number and increment it
        var count: Int = Integer.parseInt(countString)
        count++
        // Display the new value in the text view.
        textView.text = count.toString();

    }
}