package com.roque.saleshub.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeHeader() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = "Olá, Daniel",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Aqui está o resumo do seu négocio",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}