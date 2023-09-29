package com.example.reserbus21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class CargarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cargar)

        val botonAtras30 = findViewById<ImageButton>(R.id.imageButton5495)
        botonAtras30.setOnClickListener {
            val lanzar = Intent(this, menubar::class.java)
            startActivity(lanzar)
        }
    }
}