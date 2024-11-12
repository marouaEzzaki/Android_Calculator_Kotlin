package com.example.calculadora_android

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    private val gc = GestorCalculadora.getInstance()
    private val nums = mutableListOf<Double>()
    private var currentOperation = 0
    private lateinit var display: TextView
    private lateinit var userName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.textView)
        userName = intent.getStringExtra("usuario") ?: "Usuario"
        findViewById<TextView>(R.id.textViewUserName).text = "Usuario: $userName"

        setupNumberButtons()
        setupOperationButtons()
    }

    private fun setupNumberButtons() {
        val numberButtons = listOf<Button>(
            findViewById(R.id.buttonNum0),
            findViewById(R.id.buttonNum1),
            findViewById(R.id.buttonNum2),
            findViewById(R.id.buttonNum3),
            findViewById(R.id.buttonNum4),
            findViewById(R.id.buttonNum5),
            findViewById(R.id.buttonNum6),
            findViewById(R.id.buttonNum7),
            findViewById(R.id.buttonNum8),
            findViewById(R.id.buttonNum9)
        )

        numberButtons.forEach { button ->
            button.setOnClickListener {
                display.text = display.text.toString() + button.text
            }
        }
    }

    private fun setupOperationButtons() {
        val operations = mapOf(
            R.id.buttonAddition to 1,
            R.id.buttonSubstract to 2,
            R.id.buttonMultiply to 3,
            R.id.buttonDivide to 4,
            R.id.buttonResult to 5,
            R.id.buttonC to 6
        )

        operations.forEach { (id, op) ->
            findViewById<Button>(id).setOnClickListener {
                when (op) {
                    1, 2, 3, 4 -> {
                        nums.add(display.text.toString().toDouble())
                        currentOperation = op
                        display.text = ""
                    }
                    5 -> {
                        if (nums.size > 0) {
                            nums.add(display.text.toString().toDouble())
                            val result = gc.hacerOperacion(nums[0], nums[1], currentOperation)
                            display.text = result.toString()
                            nums.clear()
                        }
                    }
                    6 -> {
                        display.text = ""
                        nums.clear()
                        currentOperation = 0
                    }
                }
            }
        }
    }
}