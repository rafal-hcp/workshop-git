package workshop.git.calculator

sealed interface CalculationResult {

    data class Success(val result: Int) : CalculationResult

    data class Failure(val message: String): CalculationResult
}
