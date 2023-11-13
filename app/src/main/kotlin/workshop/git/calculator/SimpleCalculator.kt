package workshop.git.calculator

class SimpleCalculator : CalculatorApi {

    override suspend fun add(x: Int, y: Int): CalculationResult = CalculationResult.Success(x + y)

    override suspend fun substract(x: Int, y: Int): CalculationResult = CalculationResult.Success(x - y)

    override suspend fun multiply(x: Int, y: Int): CalculationResult = CalculationResult.Success(x * y)

    override suspend fun divide(x: Int, y: Int): CalculationResult = CalculationResult.Success(x / y)
}
