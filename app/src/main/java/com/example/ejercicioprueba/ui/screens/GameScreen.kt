package com.example.ejercicioprueba.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ejercicioprueba.feature.game.GameViewState
import com.example.ejercicioprueba.viewmodels.GameViewModel

@Composable
fun GameScreen(
    viewModel: GameViewModel = viewModel(),
    modifier: Modifier = Modifier
) {

    val state by viewModel.uiState.collectAsState()
    var numberInput by remember { mutableStateOf(value = "") }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Intentos maximos: ${state.gameConfiguration.maxGuesses}")
        Text(text = state.gameState.gameMessage)

        if(!state.gameState.isCompleted) {
            OutlinedTextField(
                value = numberInput,
                onValueChange = {
                    numberInput = it
                }
            )

            Text(text = "Numero de intentos: ${state.currentGuesses}")

            Button(
                onClick = {
                    viewModel.guessNumber(numberInput)
                }
            ) {
                Text(text = "Adivinar")
            }
        }
        else {
            Button(
                onClick = {
                    viewModel.resetGame()
                }
            ) {
                Text(text = "Resetear juego")
            }
        }
    }
}