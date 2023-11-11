package workshop.git.calculator

interface CalculatorApi {
    suspend fun add(x: Int, y: Int): CalculationResult

    suspend fun substract(x: Int, y: Int): CalculationResult

    suspend fun multiply(x: Int, y: Int): CalculationResult

    suspend fun divide(x: Int, y: Int): CalculationResult
}
