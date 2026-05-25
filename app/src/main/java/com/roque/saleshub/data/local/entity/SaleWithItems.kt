package com.roque.saleshub.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class SaleWithItems(
    @Embedded
    val sale: SaleEntity,

    @Relation(
        parentColumn = "createdAt",
        entityColumn = "saleId"
    )
    val items: List<SaleItemEntity>
)