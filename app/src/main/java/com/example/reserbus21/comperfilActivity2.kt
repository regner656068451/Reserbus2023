package com.example.reserbus21

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class comperfilActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comperfil2)


        val completarPerfil = findViewById<Button>(R.id.button2)
        completarPerfil.setOnClickListener {
            val lanzar = Intent(this, celular::class.java)
            startActivity(lanzar)
        }

        val atrasLogin = findViewById<ImageButton>(R.id.imageboton)
        atrasLogin.setOnClickListener{
            val lanzar = Intent(this, login::class.java)
            startActivity(lanzar)
        }
    }
}