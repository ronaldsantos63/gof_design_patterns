package com.ronaldsantos.feature.cart

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CartScreen(onBack: () -> Unit) {
    Button(onClick = onBack) { Text("Voltar") }
    Text("Carrinho")
}
