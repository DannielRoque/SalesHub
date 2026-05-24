package com.roque.saleshub.presentation.products.components

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
import com.roque.saleshub.presentation.products.ProductUi


@Composable
fun ProductCard(
    product : ProductUi,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
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
                    text = product.name,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "Estoque: ${product.stock}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Text(
                text = product.price,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}