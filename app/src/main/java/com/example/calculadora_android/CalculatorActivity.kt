package com.example.calculadora_android

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora_android.negocio.GestorCalculadora

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  gc = GestorCalculadora()

        val buttonBorrar = findViewById<Button>(R.id.buttonC)
        val buttonPow = findViewById<Button>(R.id.buttonPow)
        val buttonPorcentaje = findViewById<Button>(R.id.buttonPercentage)
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonRestar = findViewById<Button>(R.id.buttonSubstract)
        val buttonSumar = findViewById<Button>(R.id.buttonAddition)
        val buttonResult = findViewById<Button>(R.id.buttonResult)

        var operacionRealizar = 0

        val textViewIntroducirNums = findViewById<TextView>(R.id.textView)

        val operationsButtons = listOf(buttonBorrar,buttonResult,buttonPow, buttonPorcentaje, buttonDivide, buttonMultiply, buttonRestar, buttonSumar)

        val buttonNum1 = findViewById<Button>(R.id.buttonNum1)
        val buttonNum2 = findViewById<Button>(R.id.buttonNum2)
        val buttonNum3 = findViewById<Button>(R.id.buttonNum3)
        val buttonNum4 = findViewById<Button>(R.id.buttonNum4)
        val buttonNum5 = findViewById<Button>(R.id.buttonNum5)
        val buttonNum6 = findViewById<Button>(R.id.buttonNum6)
        val buttonNum7 = findViewById<Button>(R.id.buttonNum7)
        val buttonNum8 = findViewById<Button>(R.id.buttonNum8)
        val buttonNum9 = findViewById<Button>(R.id.buttonNum9)
        val buttonNum0 = findViewById<Button>(R.id.buttonNum0)
        val buttonNumComma = findViewById<Button>(R.id.buttonComma)

        val numbersButton = listOf(buttonNum1,buttonNum2,buttonNum3,buttonNum4
        ,buttonNum5, buttonNum6, buttonNum7, buttonNum8, buttonNum9, buttonNum0, buttonNumComma)

        numbersButton.forEach { number ->
           number.setOnClickListener{

               textViewIntroducirNums.text = textViewIntroducirNums.text.toString() + number.text.toString()
           }
        }
        /***
         * ME QUEDA HACER LO DEL USUARIO
         * OPCIONAL -> QUE CUANDO SE PULSE EL BOTON NARANJA SE INVIERTAN LOS COLORES
         * COMO EN IPHONE HASTA QUE PULSE OTRO NUMERO
         */

        /****
         * DA ERROR AL CALCULAR DESPUES DE BORRAR
         * ES COMO QUE SIGUE COGIENDO LOS PRIMMEROS
         * NUMEROES EN VEZ DE HACER EL CALCULO
         * he probado con el remove y no va
         */
        var nums = mutableListOf<Double>()

        operationsButtons.forEach { bt ->
            bt.setOnClickListener {
               if (bt.id == R.id.buttonPow) operacionRealizar = 1
               if (bt.id == R.id.buttonPercentage) operacionRealizar = 2
               if (bt.id == R.id.buttonDivide) operacionRealizar = 3
               if (bt.id == R.id.buttonMultiply) operacionRealizar = 4
               if (bt.id == R.id.buttonSubstract) operacionRealizar = 5
               if (bt.id == R.id.buttonAddition) operacionRealizar = 6
               if (bt.id == R.id.buttonC) {
                   textViewIntroducirNums.text = ""
                   nums.clear()
                   operacionRealizar = 0
               }

                if (bt.id != R.id.buttonC){
                    nums.add(textViewIntroducirNums.text.toString().toDouble())
                    textViewIntroducirNums.text = ""
                }

                if(bt.id == R.id.buttonResult){
                    textViewIntroducirNums.text = gc.hacerOperacion(nums.get(0), nums.get(1), operacionRealizar).toString()
                }
            }
        }
    }
}