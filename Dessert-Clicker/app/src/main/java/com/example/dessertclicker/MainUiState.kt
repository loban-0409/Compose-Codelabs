package com.example.dessertclicker

import androidx.annotation.DrawableRes

data class MainUiState(
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertIndex: Int = 0,
    val currentDessertPrice: Int = 0,
    @DrawableRes val currentDessertImageId: Int = 0,
)
