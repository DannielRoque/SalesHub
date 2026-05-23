package com.roque.saleshub.presentation.home.components

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

@Composable
fun RecentSaleCard(
    orderId: String,
    value: String
) {

    Card {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = orderId,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "Hoje, 13;45",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}