package com.example.reserbus21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class AyudaActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda2)

        val botonAtras60 = findViewById<ImageButton>(R.id.imageButton6)
        botonAtras60.setOnClickListener {
            val lanzar = Intent(this, menubar::class.java)
            startActivity(lanzar)
        }
    }
}