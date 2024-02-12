package com.example.dessertclicker

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.DefaultDessertRepository
import com.example.dessertclicker.data.DessertRepository
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<MainUiState> = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()
    private val dessertRepository: DessertRepository = DefaultDessertRepository()
    private val desserts: List<Dessert> = dessertRepository.getDesserts()

    init {
        _uiState.update { currentState ->

            currentState.copy(
                revenue = 0,
                dessertsSold = 0,
                currentDessertIndex = 0,
                currentDessertPrice = desserts.first().price,
                currentDessertImageId = desserts.first().imageId,
            )
        }
    }

    fun sellDessert() {
        _uiState.update { currentState ->
            val dessertToShow = determineDessertToShow(
                desserts = desserts,
                dessertsSold = _uiState.value.dessertsSold,
            )
            currentState.copy(
                dessertsSold = currentState.dessertsSold + 1,
                revenue = currentState.revenue + currentState.currentDessertPrice,
                currentDessertImageId = dessertToShow.imageId,
                currentDessertPrice = dessertToShow.price,
            )
        }
    }

    /**
     * Determine which dessert to show.
     */
    private fun determineDessertToShow(
        desserts: List<Dessert>,
        dessertsSold: Int,
    ): Dessert {
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                break
            }
        }

        return dessertToShow
    }
}
