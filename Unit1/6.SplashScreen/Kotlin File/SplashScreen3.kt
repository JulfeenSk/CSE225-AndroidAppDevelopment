package com.examples.unit1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreen3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen3)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                val i = Intent(this, SplashScreenMain::class.java)
                startActivity(i)
                finish() }, 1000)
    }

}