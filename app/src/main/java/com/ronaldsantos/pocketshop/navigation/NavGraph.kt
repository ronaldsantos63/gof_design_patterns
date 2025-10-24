package com.ronaldsantos.pocketshop.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ronaldsantos.feature.auth.AuthScreen
import com.ronaldsantos.feature.cart.CartScreen
import com.ronaldsantos.feature.catalog.CatalogScreen

object Routes {
    const val CATALOG = "catalog"
    const val CART = "cart"
    const val AUTH = "auth"
    const val ABOUT = "about"
}

@Composable
fun PocketNavGraph(
    modifierPadding: PaddingValues,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Routes.CATALOG,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Routes.CATALOG) { CatalogScreen(openCart = { navController.navigate(Routes.CART) }) }
        composable(Routes.CART) { CartScreen(onBack = { navController.popBackStack() }) }
        composable(Routes.AUTH) { AuthScreen(onLoggedIn = { navController.popBackStack() } ) }
        // ABOUT pode ser uma activity/feature separada via deep link; placeholder:
        composable(Routes.ABOUT) { Text("About (Dynamic Feature)") }
    }
}
