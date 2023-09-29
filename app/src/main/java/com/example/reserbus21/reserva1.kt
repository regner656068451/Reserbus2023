package com.example.reserbus21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class reserva1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserva1)

        val atrasDelBus = findViewById<ImageButton>(R.id.imageButton5495)
        atrasDelBus.setOnClickListener {
            val irAlBar = Intent(this, menubar::class.java)
            startActivity(irAlBar)
        }

        val tomarBus = findViewById<View>(R.id.rectangle_4)
        tomarBus.setOnClickListener {
            val tomarElBus = Intent(this, reserva2Activity::class.java)
            startActivity(tomarElBus)
        }
    }
}