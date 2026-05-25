package com.roque.saleshub.presentation.sales.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

private val PurplePrimary = Color(0xFF5B35F2)
private val PurpleSoft = Color(0xFFF2EEFF)

@Composable
fun SelectorField(
    title: String,
    value: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    isPlaceholder: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {

    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold,
        color = PurplePrimary
    )

    Spacer(modifier = Modifier.width(8.dp))

    Card(

        modifier = modifier.fillMaxWidth(),

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor =
                if (enabled) {
                    Color.White
                } else {
                    Color(0xFFF2F2F2)
                }
        ),

        onClick = {
            if (enabled) {
                onClick()
            }
        }

    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),

            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement =
                Arrangement.SpaceBetween

        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(

                    modifier = Modifier
                        .size(44.dp)
                        .background(
                            color = PurpleSoft,
                            shape = CircleShape
                        ),

                    contentAlignment = Alignment.Center

                ) {

                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = PurplePrimary
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = value,
                    style = MaterialTheme.typography.titleMedium,
                    color = if (isPlaceholder) {
                        Color.Gray
                    } else {
                        Color.Black
                    }
                )
            }

            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null
            )
        }
    }
}