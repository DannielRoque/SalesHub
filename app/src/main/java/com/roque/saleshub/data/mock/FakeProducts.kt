package com.roque.saleshub.data.mock

import com.roque.saleshub.data.local.entity.ProductEntity

object FakeProducts {

    val products = listOf(

        ProductEntity(
            id = 1,
            name = "Coca-Cola 350ml",
            price = 6.0,
            stock = 9
        ),

        ProductEntity(
            id = 2,
            name = "Chocolate Lacta",
            price = 8.5,
            stock = 9
        ),

        ProductEntity(
            id = 3,
            name = "Batata Pringles",
            price = 14.0,
            stock = 9
        )
    )
}