package com.example.reserbus21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class TrabajaActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trabaja2)

        val botonAtras50 = findViewById<ImageButton>(R.id.imageButton3)
        botonAtras50.setOnClickListener {
            val lanzar = Intent(this, menubar::class.java)
            startActivity(lanzar)
        }
    }
}