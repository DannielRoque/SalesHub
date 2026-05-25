package com.roque.saleshub.presentation.sales

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roque.saleshub.data.local.entity.SaleEntity
import com.roque.saleshub.data.local.entity.SaleItemEntity
import com.roque.saleshub.data.local.entity.SaleWithItems
import com.roque.saleshub.domain.SalesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SaleViewModel(
    private val repository: SalesRepository
) : ViewModel() {

    val salesState: StateFlow<List<SaleWithItems>> = repository.getAllSales()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun saveSale(
        customerName: String,
        totalPrice: Double,
        itemsCount: Int,
        items: List<SaleItemEntity>,
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch {
            val sale = SaleEntity(
                customerName = customerName,
                totalPrice = totalPrice,
                itemsCount = itemsCount
            )

            repository.saveSale(sale, items)
            onSuccess()
        }
    }
}