package com.roque.saleshub.domain.repository

import com.roque.saleshub.data.local.entity.SaleEntity
import com.roque.saleshub.data.local.entity.SaleItemEntity
import com.roque.saleshub.data.local.entity.SaleWithItems
import kotlinx.coroutines.flow.Flow

interface SalesRepository {
    fun getAllSales(): Flow<List<SaleWithItems>>
    suspend fun getSaleById(id: Long): SaleWithItems?
    suspend fun saveSale(sale: SaleEntity, items: List<SaleItemEntity>)
    suspend fun clearAllSales()
}