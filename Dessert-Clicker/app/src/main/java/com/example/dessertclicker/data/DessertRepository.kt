package com.example.dessertclicker.data

import com.example.dessertclicker.model.Dessert

interface DessertRepository {
    fun getDesserts(): List<Dessert>
}
