@file:Suppress("DEPRECATION")

package com.example.reserbus21
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider



enum class ProviderType {
    BASIC,
    GOOGLE,
    FACEBOOK


}

class login : AppCompatActivity() {

    private val callbackManager = CallbackManager.Factory.create()

    private val GOOGLE_SIGN_IN = 100
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.editLoginPassword)
        loginButton = findViewById(R.id.button310)

        loginButton.setOnClickListener {
            loginUser()
        }


        val facebookButton: View = findViewById(R.id.facebookButton)
        facebookButton.setOnClickListener {

            LoginManager.getInstance().logInWithReadPermissions(this, listOf("email, public_profile"))


            LoginManager.getInstance().registerCallback(callbackManager,
                object : FacebookCallback<LoginResult> {

                    override fun onSuccess(result: LoginResult) {
                        result?.let{
                            val token = it.accessToken
                            val credential = FacebookAuthProvider.getCredential(token.token)
                            FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener {
                                if (it.isSuccessful){
                                    showHome(it.result?.user?.email ?: "", ProviderType.FACEBOOK)
                                    irInicio()
                                    showAlert3()
                                }else{
                                    showAlert()
                                }
                            }
                        }

                    }

                    override fun onCancel() {

                    }

                    override fun onError(error: FacebookException) {
                        showAlert()
                    }

                })

        }


        /* boton crea una para ir a la pantalla de crear una cuenta e ir a rellenar
        todos los datos xd */

        val botonIrCrear = findViewById<Button>(R.id.button510)
        botonIrCrear.setOnClickListener {
            val irCrear = Intent(this, creacuenta::class.java)
            startActivity(irCrear)
        }


        // Analytics Event
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "integracion de firebase completa")
        analytics.logEvent("initScreen", bundle)



        val googleButton: View = findViewById(R.id.googleButton)
        googleButton.setOnClickListener {

            val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            val googleClient = GoogleSignIn.getClient(this, googleConf)
            googleClient.signOut()

            startActivityForResult(googleClient.signInIntent, GOOGLE_SIGN_IN)
        }

    }

    private fun loginUser() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            showToast("Los campos no pueden estar vacíos")
            return
        }

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Inicio de sesión exitoso
                    showToast("Inicio de sesión exitoso")
                    navigateToMainScreen()
                } else {
                    // Manejo de error en el inicio de sesión
                    showToast("Error en el inicio de sesión. Verifica tus credenciales.")
                }
            }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToMainScreen() {
        val intent = Intent(this, celular::class.java) // Reemplaza MainActivity con el nombre de tu actividad principal
        startActivity(intent)
    }


    private fun showAlert (){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("error")
        builder.setMessage("Error autenticando al usuario o usuario inhabilitado")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }

    private fun showAlert2 (){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Exito!")
        builder.setMessage("has iniciado sesion con Google")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showAlert3(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Exito!")
        builder.setMessage("has iniciado sesion con Facebook")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()


    }
    private fun showHome(email: String, provider: ProviderType){

    }

    private fun irInicio (){
        intent = Intent(this, menubar::class.java)
        startActivity(intent)
    }



    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        callbackManager.onActivityResult(requestCode, resultCode, data)

        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GOOGLE_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                val account = task.getResult(ApiException::class.java)

                if (account != null) {

                    val credential = GoogleAuthProvider.getCredential(account.idToken, null)

                    FirebaseAuth.getInstance().signInWithCredential(credential)
                        .addOnCompleteListener {

                            if (it.isSuccessful) {
                                showHome(account.email ?: "", ProviderType.GOOGLE)
                                showAlert2()
                                irInicio()
                            } else {
                                showAlert()

                            }
                        }

                }

            }catch(e: ApiException) {
                showAlert()

            }
        }
    }
}














