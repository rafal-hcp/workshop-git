package workshop.git.calculator

interface CalculatorApi {
    suspend fun add(x: Int, y: Int): CalculationResult

    suspend fun substract(x: Int, y: Int): CalculationResult

    suspend fun multiply(x: Int, y: Int): CalculationResult

    suspend fun divide(x: Int, y: Int): CalculationResult
}

class CalculatorApiTest: CalculatorApi {
    override suspend fun add(x: Int, y: Int): CalculationResult = CalculationResult.Success(1)

    override suspend fun substract(x: Int, y: Int): CalculationResult = CalculationResult.Success(2)

    override suspend fun multiply(x: Int, y: Int): CalculationResult = CalculationResult.Success(3)

    override suspend fun divide(x: Int, y: Int): CalculationResult = CalculationResult.Success(4)
}
