package com.roque.saleshub.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.roque.saleshub.presentation.home.HomeScreen
import com.roque.saleshub.presentation.products.ProductsScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    Scaffold(

        bottomBar = {
            BottonBar(navController = navController)
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(
                route = BottomNavItem.Home.route
            ) {
                HomeScreen()
            }

            composable(
                route = BottomNavItem.Products.route
            ) {
                ProductsScreen()
            }

            composable(
                route = BottomNavItem.Historico.route
            ) {
                //TODO Adicionar Histórico para navegação
            }

            composable(
                route = BottomNavItem.Settings.route
            ) {
                //TODO Adicionar Settings para navegação
            }
        }
    }
}