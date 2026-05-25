package com.roque.saleshub.presentation.sales.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.roque.saleshub.data.local.entity.SaleEntity
import com.roque.saleshub.presentation.util.toFormattedDate
import com.roque.saleshub.presentation.util.toFormattedDateTime

@Composable
fun SaleCard(
    sale: SaleEntity,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {

    Card(

        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }

    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            horizontalArrangement =
                Arrangement.SpaceBetween

        ) {

            Column {

                Text(
                    text = sale.customerName,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "${sale.itemsCount} itens",
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = sale.createdAt.toFormattedDateTime(),
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Text(
                text = "R$ %.2f".format(sale.totalPrice),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}