package com.roque.saleshub.presentation.sales.components.bottomsheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.roque.saleshub.data.local.entity.ProductEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductBottomSheet(
    products: List<ProductEntity>,
    onDismiss: () -> Unit,
    onProductSelected: (ProductEntity) -> Unit
) {

    ModalBottomSheet(

        onDismissRequest = onDismiss,

        sheetState = rememberModalBottomSheetState()

    ) {

        Column(
            modifier = Modifier.padding(bottom = 24.dp)
        ) {

            Text(

                text = "Selecionar produto",

                style = MaterialTheme.typography.headlineSmall,

                fontWeight = FontWeight.Bold,

                modifier = Modifier.padding(
                    horizontal = 20.dp,
                    vertical = 12.dp
                )
            )

            LazyColumn {

                items(products) { product ->

                    ProductBottomSheetItem(

                        product = product,

                        onClick = {

                            onProductSelected(product)
                            onDismiss()
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun ProductBottomSheetItem(
    product: ProductEntity,
    onClick: () -> Unit
) {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(20.dp)

    ) {

        Row(

            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.SpaceBetween

        ) {

            Column {

                Text(
                    text = product.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Estoque: ${product.stock}"
                )
            }

            Text(
                text = "R$ %.2f".format(product.price),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalDivider()
    }
}