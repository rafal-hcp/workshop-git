package workshop.git.equation

data class Equation(val x: Int, val y: Int, val operation: Operation)

enum class Operation {
    Add,
    Substract,
    Multiply,
    Divide
}
