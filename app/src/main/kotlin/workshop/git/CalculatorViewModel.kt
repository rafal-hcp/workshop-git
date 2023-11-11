package workshop.git

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import workshop.git.calculator.CalculationResult
import workshop.git.calculator.CalculatorApi
import workshop.git.equation.Equation
import workshop.git.equation.Operation

class CalculatorViewModel(
    private val calculatorApi: CalculatorApi
) {

    private val _state: MutableStateFlow<State> = MutableStateFlow(State.Idle)
    val state: StateFlow<State> = _state.asStateFlow()

    suspend fun calculate(equation: Equation) = coroutineScope {
        _state.update {
            State.Loading
        }
        delay(2000L)

        val result = when(equation.operation) {
            Operation.Add -> calculatorApi.add(equation.x, equation.y)
            Operation.Substract -> calculatorApi.substract(equation.x, equation.y)
            Operation.Divide -> calculatorApi.divide(equation.x, equation.y)
            Operation.Multiply -> calculatorApi.multiply(equation.x, equation.y)
        }

        when (result) {
            is CalculationResult.Success -> _state.update {
                State.Calculated(result.result)
            }
            is CalculationResult.Failure -> _state.update {
                State.Error(result.message)
            }
        }
    }

    sealed interface State {
        data object Idle : State

        data class Calculated(val result: Int) : State

        data object Loading : State

        data class Error(val message: String) : State
    }
}
