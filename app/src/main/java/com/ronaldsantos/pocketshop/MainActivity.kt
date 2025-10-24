package com.ronaldsantos.pocketshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import com.ronaldsantos.core.designsystem.PocketShopTheme
import com.ronaldsantos.pocketshop.navigation.PocketNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PocketShopTheme {
                Scaffold(
                    topBar = { TopAppBar(title = { Text("PocketShop") }) }
                ) { innerPadding ->
                    PocketNavGraph(modifierPadding = innerPadding)
                }
            }
        }
    }
}
