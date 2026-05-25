package com.roque.saleshub.presentation.sales.components

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
import com.roque.saleshub.data.local.entity.SaleItemEntity

@Composable
fun SaleItemCard(
    item: SaleItemEntity,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier.fillMaxWidth()
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
                    text = item.name,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "Qtd: ${item.quantity}",
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "Unitário: R$ %.2f".format(item.unitPrice),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Text(
                text = "R$ %.2f".format(item.totalPrice),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}