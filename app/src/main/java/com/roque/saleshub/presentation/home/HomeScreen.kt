package com.roque.saleshub.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.roque.saleshub.presentation.components.ScreenHeader
import com.roque.saleshub.presentation.home.components.RecentSalesSection
import com.roque.saleshub.presentation.home.components.SumaryCard

@Composable
fun HomeScreen(
    onCreateSaleClick: () -> Unit
) {

    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onCreateSaleClick
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
                Text(text = "Nova venda")
            }
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                ScreenHeader(
                    title = "Olá, Daniel",
                    subtitle = "Aqui está o resumo do seu negócio"
                )
            }

            item {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    SumaryCard(
                        title = "Total vendido",
                        value = "R$ 12.670,89",
                        modifier = Modifier.weight(1f)
                    )

                    SumaryCard(
                        title = "Vendas",
                        value = "69",
                        modifier = Modifier.weight(1f)
                    )

                }
            }

            item {
                RecentSalesSection()
            }
        }
    }
}