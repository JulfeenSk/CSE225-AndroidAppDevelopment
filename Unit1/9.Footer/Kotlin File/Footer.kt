package com.examples.unit1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView


class Footer : AppCompatActivity() {
    private lateinit var tv: TextView
    private lateinit var bottomNav: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_footer)
        tv = findViewById(R.id.ttView)
        bottomNav = findViewById(R.id.bottomNav)
        title = "Home"

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    tv.text = "Home"
                    true
                }
                R.id.menu_Profile -> {
                    tv.text = "Profile"
                    true
                }
                R.id.menu_notification -> {
                    tv.text = "Notification"
                    true
                }
                R.id.menu_search -> {
                    tv.text = "Search"
                    true
                }
                else -> true
            }
        }


    }
}