package com.roque.saleshub.presentation.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.roque.saleshub.presentation.components.ScreenHeader
import com.roque.saleshub.presentation.settings.components.SettingsItem

@Composable
fun SettingsScreen(
    onBackClick: () -> Unit
) {
    var darkModeEnabled by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        LazyColumn(

            modifier = Modifier.fillMaxSize(),

            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 8.dp
            ),

            verticalArrangement =
                Arrangement.spacedBy(12.dp)

        ) {

            item {
                ScreenHeader(
                    title = "Configurações",
                    subtitle = "",
                    onBackClick = onBackClick
                )
            }

            item {
                SettingsItem(
                    title = "Dark mode",
                    subtitle = "Habilitar dark theme",
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Palette,
                            contentDescription = null
                        )
                    },
                    trailingContent = {

                        Switch(
                            checked = darkModeEnabled,
                            onCheckedChange = {
                                darkModeEnabled = it
                            }
                        )
                    }
                )
            }

            item {

                SettingsItem(
                    title = "Limpar historico",
                    subtitle = "Remove todos os dados do app",
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = null
                        )
                    }
                )
            }

            item {

                SettingsItem(
                    title = "Versão do app",
                    subtitle = "v1.0.0",
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null
                        )
                    }
                )
            }
        }
    }
}