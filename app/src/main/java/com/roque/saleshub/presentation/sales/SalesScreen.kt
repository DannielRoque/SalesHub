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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.roque.saleshub.data.mock.FakeSales.sales
import com.roque.saleshub.presentation.components.ScreenHeader
import com.roque.saleshub.presentation.sales.components.SaleCard
import com.roque.saleshub.presentation.sales.components.SalesHeader

@Composable
fun SalesScreen(
    viewModel: SaleViewModel,
    onCreateSaleClick: () -> Unit,
    onBackClick: () -> Unit
) {
    val salesWithItems by viewModel.salesState.collectAsState()

    Scaffold(

        floatingActionButton = {

            ExtendedFloatingActionButton(

                onClick = onCreateSaleClick

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
                .padding(bottom = paddingValues.calculateBottomPadding()),

            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 8.dp),

            verticalArrangement =
                Arrangement.spacedBy(12.dp)

        ) {

            item {
                ScreenHeader(
                    title = "Histórico",
                    subtitle = "Últimos pedidos",
                    onBackClick = onBackClick
                )
            }

            items(
                items = salesWithItems,
                key = { salesWithItems ->
                    salesWithItems.sale.id
                }
            ) { salesWithItems ->

                SaleCard(
                    sale = salesWithItems.sale
                )
            }
        }
    }
}