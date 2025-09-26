package com.appweek04

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent
import com.appweek04.GreetingActivity
import com.appweek04.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGreet = findViewById<Button>(R.id.buttonGreet)

        buttonGreet.setOnClickListener {
            startActivity(Intent(this, GreetingActivity::class.java))
        }
    }
}