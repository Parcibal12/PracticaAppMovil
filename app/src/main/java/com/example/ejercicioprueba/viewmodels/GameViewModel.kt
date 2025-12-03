package com.example.ejercicioprueba.viewmodels


import androidx.compose.runtime.currentRecomposeScope
import androidx.lifecycle.ViewModel
import com.example.ejercicioprueba.data.Game
import com.example.ejercicioprueba.features.game.GameState
import com.example.ejercicioprueba.features.game.GameViewState
import com.example.ejercicioprueba.features.game.LoseState
import com.example.ejercicioprueba.features.game.PlayingState
import com.example.ejercicioprueba.features.game.WinState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(
        value = GameViewState()
    )

    val uiState: StateFlow<GameViewState> = _uiState.asStateFlow()

    fun guessNumber(number: String) {
        if(number.isNotEmpty() && number.all { c ->  c.isDigit() }) {
            _uiState.update { currentState ->

                val currentGuesses = currentState.currentGuesses + 1
                var gameState = currentState.gameState

                if(currentState.gameConfiguration.targetNumber == number.toInt()) {
                    gameState = WinState
                }
                else if(currentGuesses >= currentState.gameConfiguration.maxGuesses) {
                    gameState = LoseState
                }

                currentState.copy(
                    currentGuesses = currentGuesses,
                    gameState = gameState
                )
            }
        }
    }


    fun resetGame() {
        _uiState.update { currentState ->
            currentState.copy(
                gameState = PlayingState,
                currentGuesses = 0,
                gameConfiguration = Game()
            )
        }
    }
}