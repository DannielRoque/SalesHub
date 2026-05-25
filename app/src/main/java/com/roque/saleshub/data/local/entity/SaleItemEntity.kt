package com.roque.saleshub.data.local.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "sale_items")
data class SaleItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val saleId: Long,
    val name: String,
    val quantity: Int,
    val unitPrice: Double
) {
    @get:Ignore
    val totalPrice: Double
        get() = quantity * unitPrice
}
