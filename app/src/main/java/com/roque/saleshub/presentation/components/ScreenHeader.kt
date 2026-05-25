package com.roque.saleshub.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScreenHeader(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null
) {

    Row(

        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),

        verticalAlignment = Alignment.Top

    ) {

        if (onBackClick != null) {

            IconButton(
                onClick = onBackClick
            ) {

                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Voltar"
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
        }

        Column {

            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}