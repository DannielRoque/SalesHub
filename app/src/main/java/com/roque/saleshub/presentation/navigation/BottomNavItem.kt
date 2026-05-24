package com.roque.saleshub.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {

    data object Home : BottomNavItem(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    data object Products : BottomNavItem(
        route = "produtos",
        title = "Produtos",
        icon = Icons.Default.ShoppingCart
    )

    data object Historico : BottomNavItem(
        route = "historico",
        title = "Histórico",
        icon = Icons.Default.Person
    )

    data object Settings : BottomNavItem(
        route = "configuracoes",
        title = "Configurações",
        icon = Icons.Default.Settings
    )
}