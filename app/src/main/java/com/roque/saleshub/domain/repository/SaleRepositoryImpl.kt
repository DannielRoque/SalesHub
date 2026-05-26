package com.roque.saleshub.domain.repository

import androidx.room.withTransaction
import com.roque.saleshub.data.local.database.AppDatabase
import com.roque.saleshub.data.local.entity.SaleEntity
import com.roque.saleshub.data.local.entity.SaleItemEntity
import com.roque.saleshub.data.local.entity.SaleWithItems
import kotlinx.coroutines.flow.Flow

class SalesRepositoryImpl(
    private val database: AppDatabase
) : SalesRepository {

    private val saleDao = database.saleDao()

    override fun getAllSales(): Flow<List<SaleWithItems>> {
        return saleDao.getAllSalesWithItems()
    }

    override suspend fun getSaleById(id: Long): SaleWithItems? {
        return saleDao.getSaleById(id)
    }

    override suspend fun saveSale(sale: SaleEntity, items: List<SaleItemEntity>) {
        database.withTransaction {
            saleDao.insertSale(sale)

            val itemsWithSaleId = items.map { it.copy(saleId = sale.createdAt) }

            saleDao.insertSaleItems(itemsWithSaleId)
        }
    }

    override suspend fun clearAllSales() {
        saleDao.deleteAllSales()
    }
}