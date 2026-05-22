package com.roque.saleshub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.roque.saleshub.presentation.navigation.AppNavigation
import com.roque.saleshub.ui.theme.SalesHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SalesHubTheme {
                AppNavigation()
            }
        }
    }
}