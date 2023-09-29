package com.example.reserbus21

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.hbb20.CountryCodePicker


class creacuenta : AppCompatActivity() {


    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var dobEditText: EditText
    private lateinit var countryCodePicker: CountryCodePicker
    private lateinit var phoneNumberEditText: EditText
    private lateinit var spinnerGender: Spinner
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creacuenta)

        val spinnerGender: Spinner = findViewById(R.id.spinnerGender)
        val genderOptions = arrayOf("Masculino", "Femenino", "Otro")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = adapter




        emailEditText = findViewById(R.id.editTextRegistro)
        passwordEditText = findViewById(R.id.passRegistro)
        confirmPasswordEditText = findViewById(R.id.passConfirmarRegistro)
        nameEditText = findViewById(R.id.nombreRegistro)
        dobEditText = findViewById(R.id.editTextDate)
        registerButton = findViewById(R.id.button2145)

        registerButton.setOnClickListener {
            registerUser()
        }




        val botonAtras10 = findViewById<ImageButton>(R.id.imageButton510)
        botonAtras10.setOnClickListener {
            val lanzar = Intent(this, login::class.java)
            startActivity(lanzar)
        }


    }



    private fun registerUser() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val confirmPassword = confirmPasswordEditText.text.toString()
        val dob = dobEditText.text.toString()
        val name = nameEditText.text.toString()


        if (password != confirmPassword) {
            confirmPasswordEditText.error = "las contras no coinciden"
            return

        }


        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = FirebaseAuth.getInstance().currentUser
                    val userReference =
                        FirebaseDatabase.getInstance().getReference("users").child(user!!.uid)
                    navigateToLoginScreen()
                    showToast("Registro exitoso!")

                    val userData = HashMap<String, Any>()
                    userData["nombre"] = name
                    userData["fechaNacimiento"] = dob
                    userData["genero"] = spinnerGender.selectedItem.toString() // Obtener el género seleccionado del Spinner


                    userReference.setValue(userData)
                        .addOnCompleteListener { dbTask ->
                            if (dbTask.isSuccessful) {
                                //hacer la logica para ir a la siguiente screen
                                navigateToLoginScreen()
                                showToast("Registro exitante!")

                            }
                        }
                } else {
                    // Manejo de error en el registro de usuario
                    showToast("REVISA TODOS LOS CAMPOS!")

                }
            }

    }



    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToLoginScreen() {
        val intent = Intent(this, login::class.java)
        startActivity(intent)

    }


}


