package com.roque.saleshub.presentation.sales

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
import com.roque.saleshub.presentation.sales.components.SaleCard
import com.roque.saleshub.presentation.sales.components.SalesHeader
import com.roque.saleshub.presentation.sales.model.SaleUi

@Composable
fun SalesScreen() {
    val sales = listOf(

        SaleUi(
            id = 1,
            customerName = "Daniel",
            total = "R$ 230,00",
            itemsCount = 3,
            date = "Hoje, 10:45"
        ),

        SaleUi(
            id = 2,
            customerName = "Maria",
            total = "R$ 540,00",
            itemsCount = 6,
            date = "Hoje, 09:10"
        ),

        SaleUi(
            id = 3,
            customerName = "José",
            total = "R$ 120,00",
            itemsCount = 2,
            date = "Ontem, 19:20"
        )
    )

    Scaffold(

        floatingActionButton = {

            ExtendedFloatingActionButton(

                onClick = {
                    // navegar para CreateSaleScreen
                }

            ) {

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )

                Text(text = "Nova venda")
            }
        }

    ) { paddingValues ->

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),

            contentPadding = PaddingValues(16.dp),

            verticalArrangement =
                Arrangement.spacedBy(12.dp)

        ) {

            item {
                SalesHeader()
            }

            items(
                items = sales,
                key = { sale ->
                    sale.id
                }
            ) { sale ->

                SaleCard(
                    sale = sale
                )
            }
        }
    }
}