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
import com.roque.saleshub.data.mock.FakeProducts.products
import com.roque.saleshub.presentation.components.ScreenHeader
import com.roque.saleshub.presentation.products.components.ProductCard

@Composable
fun ProductsScreen(
    onBackClick: () -> Unit
) {

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
                    .padding(bottom = paddingValues.calculateBottomPadding()),
            contentPadding = PaddingValues(16.dp),

            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {
                ScreenHeader(
                    title = "Produtos",
                    subtitle = "",
                    onBackClick = onBackClick
                )
            }

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