package com.example.ejercicioprueba.data


data class Game(
    val targetNumber: Int = (0..5).random(),
    val maxGuesses: Int = 5
)
