package com.example.calculadora_android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class UserActivity : AppCompatActivity() {


    private val K_USUARIO: String = "usuario"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val intent: Intent = Intent(
            this@UserActivity,
            CalculatorActivity::class.java
        )

        val buttonAccept = findViewById<Button>(R.id.buttonAccept)

        buttonAccept.setOnClickListener {
            val usersName = findViewById<EditText>(R.id.editTextUser)

            if (usersName.text.isNotEmpty()){
                intent.putExtra(K_USUARIO, usersName.text.toString())
                startActivity(intent)
            }
        }
    }
}