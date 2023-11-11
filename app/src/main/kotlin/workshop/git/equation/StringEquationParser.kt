package workshop.git.equation

class StringEquationParser : EquationParser<String>{

    override fun parse(equation: String): Equation {
        val (x, operator, y) = """(\d*)([+\-*/])(\d*)""".toRegex().find(equation)!!.destructured
        return Equation(x.toInt(), y.toInt(), when(operator) {
            "-" -> Operation.Substract
            "+" -> Operation.Add
            "*" -> Operation.Multiply
            "/" -> Operation.Divide
            else -> throw UnsupportedOperationException()
        })
    }
}
