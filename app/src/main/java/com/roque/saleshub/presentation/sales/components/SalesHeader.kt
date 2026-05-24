package com.roque.saleshub.presentation.sales.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SalesHeader() {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Histórico de vendas",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Acompanhe todas as vendas realizadas",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}