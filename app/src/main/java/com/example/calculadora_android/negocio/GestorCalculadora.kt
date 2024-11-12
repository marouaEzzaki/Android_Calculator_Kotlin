class GestorCalculadora private constructor() {

    companion object {
        private var instance: GestorCalculadora? = null

        fun getInstance(): GestorCalculadora {
            if (instance == null) {
                instance = GestorCalculadora()
            }
            return instance!!
        }
    }

    fun hacerOperacion(num1: Double, num2: Double, operation: Int): Double {
        return when (operation) {
            1 -> num1 + num2
            2 -> num1 - num2
            3 -> num1 * num2
            4 -> if (num2 != 0.0) num1 / num2 else 0.0
            else -> 0.0
        }
    }
}
