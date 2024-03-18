package com.examples.unit1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class ScrollRatingSplash1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_rating_splash1)
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val i = Intent(this, ScrollRatingSplash2::class.java)
                startActivity(i)
                finish() }, 1000)
    }
}