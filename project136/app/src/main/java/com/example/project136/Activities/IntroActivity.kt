package com.example.project136.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.project136.R

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        val introBtn = findViewById<ConstraintLayout>(R.id.introBtn)
        introBtn.setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    this@IntroActivity,
                    Login::class.java
                )
            )
        }
    }
}