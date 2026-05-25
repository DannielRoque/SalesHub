package com.roque.saleshub.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sales")
data class SaleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val customerName: String,
    val totalPrice: Double,
    val itemsCount: Int,
    val createdAt: Long = System.currentTimeMillis()
)