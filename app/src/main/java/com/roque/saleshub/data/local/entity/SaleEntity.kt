package com.roque.saleshub.data.local.entity

data class SaleEntity(
    val id: Int,
    val customerName: String,
    val totalPrice: Double,
    val itemsCount: Int,
    val date: String
)