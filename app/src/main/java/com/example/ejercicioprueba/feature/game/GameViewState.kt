package com.example.ejercicioprueba.feature.game

import com.example.ejercicioprueba.data.Game

data class GameViewState(
    val currentGuesses: Int = 0,
    val gameConfiguration: Game = Game(),
    val gameState: GameState = PlayingState
)