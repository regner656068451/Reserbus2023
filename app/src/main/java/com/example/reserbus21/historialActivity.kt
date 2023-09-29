package com.example.reserbus21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class historialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        val botonAtras40 = findViewById<ImageButton>(R.id.imageButton4)
        botonAtras40.setOnClickListener {
            val lanzar = Intent(this, menubar::class.java)
            startActivity(lanzar)
        }
    }
}