package com.roque.saleshub.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.roque.saleshub.data.local.dao.sale.SaleDao
import com.roque.saleshub.data.local.database.AppDatabase
import com.roque.saleshub.data.local.entity.SaleEntity
import com.roque.saleshub.data.local.entity.SaleItemEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class SaleDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var saleDao: SaleDao

    @Before
    fun createDb() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries()
            .build()

        saleDao = database.saleDao()
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun insertSaleAndReadInList() = runTest {
        val currentTimestamp = System.currentTimeMillis()

        val sale = SaleEntity(
            id = 1,
            customerName = "Poatan",
            totalPrice = 250.0,
            itemsCount = 1,
            createdAt = currentTimestamp
        )

        val item = SaleItemEntity(
            id = 0,
            saleId = currentTimestamp,
            name = "Luvas",
            quantity = 1,
            unitPrice = 250.0
        )

        // Act
        saleDao.insertSale(sale)
        saleDao.insertSaleItems(listOf(item))

        val allSalesWithItems = saleDao.getAllSalesWithItems().first()

        // Assert
        assertEquals(
            "A lista de vendas deveria conter exatamente 1 registro",
            1,
            allSalesWithItems.size
        )
        assertEquals("Poatan", allSalesWithItems[0].sale.customerName)

        assertEquals(
            "A venda deveria conter exatamente 1 item vinculado",
            1,
            allSalesWithItems[0].items.size
        )
        assertEquals("Luvas", allSalesWithItems[0].items[0].name)
    }

    @Test
    fun deleteAllSalesShouldLeaveTableEmpty() = runTest {

        val sale = SaleEntity(
            id = 2,
            customerName = "Avaliador",
            totalPrice = 50.0,
            itemsCount = 1,
            createdAt = System.currentTimeMillis()
        )
        saleDao.insertSale(sale)

        // Act
        saleDao.deleteAllSales()
        val allSales = saleDao.getAllSalesWithItems().first()

        // Assert
        assertTrue(allSales.isEmpty())
    }
}