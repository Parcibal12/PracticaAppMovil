package com.example.ejercicioprueba.feature.game

sealed class GameState {
    abstract val isCompleted: Boolean

    abstract val gameMessage: String
}


data object WinState: GameState() {
    override val isCompleted: Boolean = true
    override val gameMessage: String = "Felicidades has ganado el juego"
}

data object LoseState: GameState() {
    override val isCompleted: Boolean = true
    override val gameMessage: String = "Rayos, intentalo otra vez."
}


data object PlayingState: GameState() {
    override val isCompleted: Boolean = false;
    override val gameMessage: String = "Adivina el numero que esta pensando la app!"
}