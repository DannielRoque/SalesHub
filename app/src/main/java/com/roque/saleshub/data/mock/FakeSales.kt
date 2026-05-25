package com.roque.saleshub.data.mock

import com.roque.saleshub.data.local.entity.SaleEntity

object FakeSales {

    val sales = listOf(

        SaleEntity(
            id = 1,
            customerName = "Daniel Tedola",
            totalPrice = 15.5,
            itemsCount = 9,
            date = "27/12/2026"
        )
    )
}