package com.roque.saleshub.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun RecentSalesSection() {

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Pedidos recentes",
            style = MaterialTheme.typography.titleLarge
        )

        RecentSaleCard(
            orderId = "#10023",
            value = "R$ 230,50"
        )

        RecentSaleCard(
            orderId = "#10022",
            value = "R$ 150,00"
        )

        RecentSaleCard(
            orderId = "#10021",
            value = "R$ 320,00"
        )
    }
}