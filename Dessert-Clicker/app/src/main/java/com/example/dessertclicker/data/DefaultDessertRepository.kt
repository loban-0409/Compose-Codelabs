package com.example.dessertclicker.data

import com.example.dessertclicker.model.Dessert

class DefaultDessertRepository : DessertRepository {
    override fun getDesserts(): List<Dessert> = Datasource.dessertList
}
