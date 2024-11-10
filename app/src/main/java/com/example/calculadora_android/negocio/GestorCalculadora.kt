package com.example.calculadora_android.negocio

class GestorCalculadora {

    fun hacerOperacion (num1 : Double, num2 : Double , operationToDo : Int) : Double {
        var result : Double = when (operationToDo){
            1 -> Math.pow(num1, num2)
            2 ->  (num1 *num2) / 100
            3 -> if (num2 > 0 ) num1 / num2 else 0.0
            4 -> num1 * num2
            5 -> num1 - num2
            6 -> num1 + num2
            else -> {0.0}
        }

        return result
    }
}