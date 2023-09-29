package com.example.reserbus21

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity



class bienvenido : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)
        Handler().postDelayed({
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish()
        }, 2000)

    }
}