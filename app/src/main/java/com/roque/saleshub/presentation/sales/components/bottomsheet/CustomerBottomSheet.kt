package com.roque.saleshub.presentation.sales.components.bottomsheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.roque.saleshub.data.local.entity.CustomerEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomerBottomSheet(
    customers: List<CustomerEntity>,
    onDismiss: () -> Unit,
    onCustomerSelected: (CustomerEntity) -> Unit
) {

    ModalBottomSheet(

        onDismissRequest = onDismiss,

        sheetState = rememberModalBottomSheetState()

    ) {

        Column(
            modifier = Modifier.padding(bottom = 24.dp)
        ) {

            Text(

                text = "Selecionar cliente",

                style = MaterialTheme.typography.headlineSmall,

                fontWeight = FontWeight.Bold,

                modifier = Modifier.padding(
                    horizontal = 20.dp,
                    vertical = 12.dp
                )
            )

            LazyColumn {

                items(customers) { customer ->

                    Column(

                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {

                                onCustomerSelected(customer)
                                onDismiss()
                            }
                            .padding(20.dp)

                    ) {

                        Text(
                            text = customer.name,
                            style = MaterialTheme.typography.titleMedium
                        )

                        HorizontalDivider(
                            modifier = Modifier.padding(top = 16.dp)
                        )
                    }
                }
            }
        }
    }
}