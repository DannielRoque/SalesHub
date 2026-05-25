package com.roque.saleshub.presentation.sales.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

private val PurplePrimary = Color(0xFF5B35F2)

@Composable
fun TotalSection(
    totalPrice: Double,
    isEnabled: Boolean,
    modifier: Modifier = Modifier,
    onFinishOrderClick: () -> Unit
) {

    Surface(
        modifier = modifier,
        tonalElevation = 4.dp,
        color = Color.White
    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp,
                    vertical = 16.dp
                )
                .navigationBarsPadding(),

            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement =
                Arrangement.SpaceBetween

        ) {

            Column {

                Text(
                    text = "TOTAL",
                    color = PurplePrimary,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = "R$ %.2f".format(totalPrice),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            Button(

                onClick = onFinishOrderClick,
                enabled = isEnabled,
                shape = RoundedCornerShape(16.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = PurplePrimary
                )

            ) {

                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Finalizar pedido"
                )
            }
        }
    }
}