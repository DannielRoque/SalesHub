package com.roque.saleshub.presentation.sales.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.roque.saleshub.data.local.entity.SaleItemEntity
private val PurplePrimary = Color(0xFF5B35F2)
private val PurpleSoft = Color(0xFFF2EEFF)
private val DangerColor = Color(0xFFFF4D4F)

@Composable
fun AddedProductCard(
    item: SaleItemEntity,
    modifier: Modifier = Modifier,
    onRemoveClick: () -> Unit
) {

    Card(

        modifier = modifier.fillMaxWidth(),

        shape = RoundedCornerShape(24.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )

    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),

            verticalAlignment = Alignment.CenterVertically

        ) {

            Box(

                modifier = Modifier
                    .size(72.dp)
                    .background(
                        color = PurpleSoft,
                        shape = RoundedCornerShape(20.dp)
                    ),

                contentAlignment = Alignment.Center

            ) {

                Icon(
                    imageVector = Icons.Outlined.Inventory2,
                    contentDescription = null,
                    tint = PurplePrimary,
                    modifier = Modifier.size(32.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = item.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Quantidade: ${item.quantity}"
                )

                Text(
                    text = "Unitário: R$ %.2f".format(item.unitPrice)
                )
            }

            Column(
                horizontalAlignment = Alignment.End
            ) {

                Text(
                    text = "R$ %.2f".format(item.totalPrice),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                IconButton(
                    onClick = onRemoveClick
                ) {

                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = null,
                        tint = DangerColor
                    )
                }
            }
        }
    }
}