package com.roque.saleshub.data.mock

import com.roque.saleshub.data.local.entity.CustomerEntity

object FakeCustomers {

    val customers = listOf(

        CustomerEntity(
            id = 2,
            name = "Wanderlei Silva"
        ),        CustomerEntity(
            id = 4,
            name = "Mario Covas"
        ),        CustomerEntity(
            id = 6,
            name = "Frederico Awsentix"
        ),        CustomerEntity(
            id = 8,
            name = "Tio Patinhas"
        ),        CustomerEntity(
            id = 10,
            name = "Cristiano Ronaldo"
        )
    )
}