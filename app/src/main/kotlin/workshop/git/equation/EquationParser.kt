package workshop.git.equation

interface EquationParser<T> {
    fun parse(equation: T): Equation
}
