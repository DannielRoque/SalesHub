package com.roque.saleshub.data.local.entity

data class SaleItemEntity(
    val id: Int,
    val name: String,
    val quantity: Int,
    val unitPrice: Double
) {

    val totalPrice: Double
        get() = quantity * unitPrice
}
