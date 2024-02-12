package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource.dessertList
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertClickerViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DessertClickerUiState())
    val uiState: StateFlow<DessertClickerUiState> = _uiState.asStateFlow()

    fun dessertClick() {
        updateRevenue()
        showNextDessert()
    }

    private fun updateRevenue() {
        _uiState.update {
            it.copy(
                revenue = _uiState.value.revenue + _uiState.value.currentDessertPrice,
                dessertsSold = _uiState.value.dessertsSold + 1
            )
        }
    }

    private fun showNextDessert() {
        val dessertToShow =
            determineDessertToShow(_uiState.value.dessertsSold)
        _uiState.update {
            it.copy(
                currentDessertImageId = dessertToShow.imageId,
                currentDessertPrice = dessertToShow.price,
            )
        }
    }

    private fun determineDessertToShow(
        dessertsSold: Int
    ): Dessert {
        var dessertToShow = dessertList.first()
        for (dessert in dessertList) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                break
            }
        }

        return dessertToShow
    }

}
