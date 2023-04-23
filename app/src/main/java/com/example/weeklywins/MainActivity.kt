package com.example.weeklywins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weeklywins.R
import com.example.weeklywins.screens.HomeScreenFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Replace default fragment with HomeFragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeScreenFragment())
            .commit()
    }
}