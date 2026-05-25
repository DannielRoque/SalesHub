package com.roque.saleshub.presentation.sales

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.roque.saleshub.data.local.entity.CustomerEntity
import com.roque.saleshub.data.local.entity.ProductEntity
import com.roque.saleshub.data.local.entity.SaleItemEntity
import com.roque.saleshub.data.mock.FakeCustomers
import com.roque.saleshub.data.mock.FakeProducts
import com.roque.saleshub.presentation.components.ScreenHeader
import com.roque.saleshub.presentation.sales.components.AddedProductCard
import com.roque.saleshub.presentation.sales.components.QuantitySelector
import com.roque.saleshub.presentation.sales.components.SelectorField
import com.roque.saleshub.presentation.sales.components.TotalSection
import com.roque.saleshub.presentation.sales.components.bottomsheet.CustomerBottomSheet
import com.roque.saleshub.presentation.sales.components.bottomsheet.ProductBottomSheet

private val BackgroundColor = Color(0xFFF8F7FC)
private val PurplePrimary = Color(0xFF5B35F2)
private val DisabledColor = Color(0xFFD8D5E3)

@Composable
fun CreateSaleScreen(
    viewModel: SaleViewModel,
    onBackClick: () -> Unit
) {

    val customers = FakeCustomers.customers

    val products = FakeProducts.products

    var selectedCustomer by remember {
        mutableStateOf<CustomerEntity?>(null)
    }

    var selectedProduct by remember {
        mutableStateOf<ProductEntity?>(null)
    }

    var showCustomersSheet by remember {
        mutableStateOf(false)
    }

    var showProductsSheet by remember {
        mutableStateOf(false)
    }

    var quantity by rememberSaveable {
        mutableIntStateOf(1)
    }

    val addedProducts = remember { mutableStateListOf<SaleItemEntity>() }
    val totalPrice = addedProducts.sumOf { it.totalPrice }
    val totalItemsCount = addedProducts.sumOf { it.quantity }

    val hasProducts = addedProducts.isNotEmpty()

    val isFinishEnabled = hasProducts && selectedCustomer != null

    Scaffold(

        containerColor = BackgroundColor,

        bottomBar = {

            TotalSection(
                totalPrice = totalPrice,
                isEnabled = isFinishEnabled,
                onFinishOrderClick = {
                    viewModel.saveSale(
                        customerName = selectedCustomer?.name ?: "Cliente Desconhecido",
                        totalPrice = totalPrice,
                        itemsCount = totalItemsCount,
                        items = addedProducts.toList(),
                        onSuccess = {
                            onBackClick()
                        }
                    )
                }
            )
        }

    ) { paddingValues ->

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),

            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 8.dp),

            verticalArrangement =
                Arrangement.spacedBy(12.dp)

        ) {

            item {
                ScreenHeader(

                    title = "Nova venda",

                    subtitle = "Adicione produtos ao pedido",

                    onBackClick = onBackClick
                )
            }

            item {

                SelectorField(
                    title = "Cliente",
                    value = selectedCustomer?.name ?: "Toque para selecionar",
                    icon = Icons.Default.Person,
                    isPlaceholder = selectedCustomer == null,
                    enabled = !hasProducts,
                    onClick = {
                        showCustomersSheet = true
                    }
                )
            }

            item {

                SelectorField(

                    title = "Produto",

                    value = selectedProduct?.name
                        ?: "Toque para selecionar",

                    icon = Icons.Outlined.Inventory2,

                    isPlaceholder = selectedProduct == null,

                    onClick = {
                        showProductsSheet = true
                    }
                )
            }

            item {

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    QuantitySelector(

                        quantity = quantity,

                        modifier = Modifier.weight(1f),

                        onIncrease = {
                            quantity++
                        },

                        onDecrease = {

                            if (quantity > 1) {
                                quantity--
                            }
                        }
                    )

                    Button(

                        onClick = {
                            selectedProduct?.let { product ->

                                addedProducts.add(

                                    SaleItemEntity(
                                        saleId = 0,
                                        id = product.id,
                                        name = product.name,
                                        quantity = quantity,
                                        unitPrice = product.price
                                    )
                                )

                                selectedProduct = null
                                quantity = 1
                            }
                        },

                        enabled = selectedProduct != null,

                        modifier = Modifier.weight(1f),

                        colors = ButtonDefaults.buttonColors(
                            containerColor = PurplePrimary,
                            disabledContainerColor = DisabledColor
                        )

                    ) {

                        Text(
                            text = "Adicionar"
                        )
                    }
                }
            }

            items(
                items = addedProducts
            ) { item ->

                AddedProductCard(
                    item = item,
                    onRemoveClick = {
                        addedProducts.remove(item)
                    }
                )
            }
        }
    }
    if (showProductsSheet) {

        ProductBottomSheet(

            products = products,

            onDismiss = {
                showProductsSheet = false
            },

            onProductSelected = { product ->
                selectedProduct = product
            }
        )
    }
    if (showCustomersSheet) {

        CustomerBottomSheet(

            customers = customers,

            onDismiss = {
                showCustomersSheet = false
            },

            onCustomerSelected = { customer ->
                selectedCustomer = customer
            }
        )
    }
}