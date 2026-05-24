package com.roque.saleshub.presentation.products

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.roque.saleshub.presentation.products.components.ProductCard

data class ProductUi(
    val id: Int,
    val name: String,
    val price: String,
    val stock: Int
)

@Composable
fun ProductsScreen() {

    val products = listOf(
        ProductUi(
            id = 1,
            name = "Coca-Cola 2L",
            price = "R$ 12,00",
            stock = 10
        ),
        ProductUi(
            id = 2,
            name = "Chocolate",
            price = "R$ 8,50",
            stock = 20
        ),
        ProductUi(
            id = 3,
            name = "Arroz 5kg",
            price = "R$ 32,00",
            stock = 15
        )
    )

    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(onClick = {
                //TODO ação add itens
            }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )

                Text(text = "Novo produto")
            }
        }
    ) { paddingValues ->

        LazyColumn(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),

            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = products,
                key = { product ->
                    product.id
                }
            ) { product ->

                ProductCard(
                    product = product
                )
            }
        }
    }
}