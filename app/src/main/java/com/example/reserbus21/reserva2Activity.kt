package com.example.reserbus21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class reserva2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserva2)

        val botonReservar = findViewById<Button>(R.id.button701)
        botonReservar.setOnClickListener {
            val reservar = Intent(this, menubar::class.java)
            startActivity(reservar)
        }

        val atrasDelAsiento = findViewById<ImageButton>(R.id.imageButton54951)
        atrasDelAsiento.setOnClickListener {
            val irAlAsiento = Intent(this, reserva1::class.java)
            startActivity(irAlAsiento)
        }

    }
}