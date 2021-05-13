package com.example.lection4


import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class MyObserver: LifecycleObserver {
    private lateinit var textView : TextView
    constructor(textView : TextView)
    {
        this.textView = textView
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun myFun(source: LifecycleOwner, event: Lifecycle.Event){
        textView.text =  "${textView.text} ${event.toString()}  \n"
        Log.d("TAG", event.toString())
    }
}