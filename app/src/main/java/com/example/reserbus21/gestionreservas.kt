package com.example.reserbus21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class gestionreservas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestionreservas)

        val botonAtras20 = findViewById<ImageButton>(R.id.imageButton5)
        botonAtras20.setOnClickListener {
            val lanzar = Intent(this, menubar::class.java)
            startActivity(lanzar)
        }
    }
}