package com.example.reserbus21

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class confirmarnum : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.confirmarnum)


            val fake = findViewById<Button>(R.id.verificarfake)
            fake.setOnClickListener {
                val mensaje = "Codigo de verificacion invalido"
                val duracion = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, mensaje, duracion)
                toast.show()
            }

            val acceder = findViewById<Button>(R.id.verificarBotonLoco)
            acceder.setOnClickListener {
                val lanzar = Intent(this, menubar::class.java)
                startActivity(lanzar)
                val dira = "Registro Exitoso"
                val tiempo = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, dira, tiempo)
                toast.show()

            }
        }
    }
