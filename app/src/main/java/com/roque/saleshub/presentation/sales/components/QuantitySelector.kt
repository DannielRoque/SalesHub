package com.roque.saleshub.presentation.sales.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun QuantitySelector(
    quantity: Int,
    modifier: Modifier = Modifier,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {

    Row(

        modifier = modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 12.dp, vertical = 6.dp),

        verticalAlignment = Alignment.CenterVertically,

        horizontalArrangement =
            Arrangement.SpaceBetween

    ) {

        TextButton(
            onClick = onDecrease
        ) {

            Text(
                text = "-",
                style = MaterialTheme.typography.headlineMedium
            )
        }

        Text(
            text = quantity.toString(),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        TextButton(
            onClick = onIncrease
        ) {

            Text(
                text = "+",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}