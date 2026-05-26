package com.roque.saleshub.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.roque.saleshub.data.local.database.AppDatabase
import com.roque.saleshub.domain.repository.SalesRepositoryImpl
import com.roque.saleshub.presentation.home.HomeScreen
import com.roque.saleshub.presentation.products.ProductsScreen
import com.roque.saleshub.presentation.sales.CreateSaleScreen
import com.roque.saleshub.presentation.sales.SaleViewModel
import com.roque.saleshub.presentation.sales.SalesScreen
import com.roque.saleshub.presentation.settings.SettingsScreen

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
                HomeScreen(onCreateSaleClick = { navController.navigate(Routes.CREATE_SALE) })
            }

            composable(
                route = BottomNavItem.Products.route
            ) {
                ProductsScreen(onBackClick = { navController.popBackStack() })
            }

            composable(
                route = BottomNavItem.Historico.route
            ) {
                val saleViewModel: SaleViewModel = dependencyInjectedViewModel()

                SalesScreen(
                    viewModel = saleViewModel,
                    onCreateSaleClick = {
                        navController.navigate(Routes.CREATE_SALE)
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }

            composable(
                route = BottomNavItem.Settings.route
            ) {
                SettingsScreen(onBackClick = { navController.popBackStack() })
            }

            composable(
                route = Routes.CREATE_SALE
            ) {
                val saleViewModel: SaleViewModel = dependencyInjectedViewModel()

                CreateSaleScreen(
                    viewModel = saleViewModel,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

@Composable
inline fun <reified T : ViewModel> dependencyInjectedViewModel(): T {
    val context = LocalContext.current
    return viewModel(
        factory = object : ViewModelProvider.Factory {
            override fun <V : ViewModel> create(modelClass: Class<V>): V {
                val database = AppDatabase.getDatabase(context)

                val repository = SalesRepositoryImpl(database)

                if (modelClass.isAssignableFrom(SaleViewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST")
                    return SaleViewModel(repository) as V
                }
                throw IllegalArgumentException("ViewModel não mapeada no factory: ${modelClass.name}")
            }
        }
    )
}