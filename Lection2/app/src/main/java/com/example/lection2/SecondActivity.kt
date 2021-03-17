package com.example.lection2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class SecondActivity : AppCompatActivity() {
    private lateinit var textview_random: TextView
    private lateinit var textview_label: TextView
    private lateinit var NextRandomButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textview_random = findViewById(R.id.textview_random)
        textview_label = findViewById(R.id.textview_label)
        NextRandomButton = findViewById(R.id.Random)
        showRandomNumber()
    }
    companion object {
        const val TOTAL_COUNT = "total_count"
        const val Button_Name = "Button_Name"
    }
    fun showRandomNumber()
    {
        val count = intent.getIntExtra(TOTAL_COUNT, 0)
        val random = Random()
        var randomInt = 0
        if (count > 0) {
            // Add one because the bound is exclusive
            randomInt = random.nextInt(count + 1)
        }
        textview_random.text = Integer.toString(randomInt)
        textview_label.text = getString(R.string.Random_label, count)

    }
    fun NextRandomMe(view: View)
    {
        showRandomNumber();
        val ButtonName = intent.getStringExtra(Button_Name)
        NextRandomButton.text = ButtonName;
    }
}