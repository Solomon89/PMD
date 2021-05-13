package com.example.lection4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var textView : TextView
    private lateinit var textView2 : TextView
    private lateinit var button : Button
    private lateinit var editText : EditText
    lateinit var myObserver: MyObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.mainText)
        textView2 = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)
        toastMeState("ON_CREATE")
        myObserver = MyObserver(textView)
        lifecycle.addObserver(myObserver)
        button.setOnClickListener {
            textView2.text = editText.text
        }

    }
    private fun toastMeState(message: String) {
        var text = "${lifecycle.currentState}, $message"
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        textView.text =  "${textView.text} $text  \n"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run {
            putString("textViewValue", textView2.text.toString())
        }
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView2.text = savedInstanceState?.getString("textViewValue")
    }
    /*override fun onStart() {
        super.onStart()
        toastMeState("ON_START")

    }
    override fun onResume() {
        super.onResume()
        toastMeState("ON_RESUME")
    }
    */
    /*override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        toastMeState("ON_WINDOW_FOCUS_CHANGED ${hasFocus.toString()}")
    }*/
    /*
    override fun onPostResume() {
        super.onPostResume()
        toastMeState("onPostResume")
    }
    override fun onPause() {
        super.onPause()
        toastMeState("ON_PAUSE")
    }
    override fun onStop() {
        super.onStop()
        toastMeState("ON_STOP")
    }
    override fun onRestart() {
        super.onRestart()
        toastMeState("onRestart")
    }
    override fun onDestroy() {
        super.onDestroy()
        toastMeState("ON_DESTROY")
    }*/
}