package com.roque.saleshub.presentation.sales

import com.roque.saleshub.data.local.entity.SaleEntity
import com.roque.saleshub.data.local.entity.SaleItemEntity
import com.roque.saleshub.domain.repository.SalesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.kotlin.any
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@OptIn(ExperimentalCoroutinesApi::class)
class SaleViewModelTest {

    private val repository: SalesRepository = mock()

    private val testDispatcher = StandardTestDispatcher()

    private lateinit var viewModel: SaleViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)

        `when`(repository.getAllSales()).thenReturn(flowOf(emptyList()))

        viewModel = SaleViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun salesState_should_emit_empty_list_initially_from_repository() = runTest {

        val actualState = viewModel.salesState.first()

        assertTrue(actualState.isEmpty())
    }

    @Test
    fun saveSale_should_forward_correct_entity_and_items_to_repository() = runTest {

        val customerName = "Daniel"
        val totalPrice = 150.0
        val itemsCount = 2
        val fakeItems = listOf(
            SaleItemEntity(id = 1, saleId = 0, name = "Roupa Nova", quantity = 2, unitPrice = 75.0)
        )
        var callbackChamado = false

        viewModel.saveSale(
            customerName = customerName,
            totalPrice = totalPrice,
            itemsCount = itemsCount,
            items = fakeItems,
            onSuccess = { callbackChamado = true }
        )

        advanceUntilIdle()

        val saleCaptor = argumentCaptor<SaleEntity>()
        verify(repository).saveSale(saleCaptor.capture(), any())

        assertEquals(customerName, saleCaptor.firstValue.customerName)
        assertEquals(totalPrice, saleCaptor.firstValue.totalPrice, 0.0)
        assertEquals(itemsCount, saleCaptor.firstValue.itemsCount)

        assertTrue(callbackChamado)
    }
}