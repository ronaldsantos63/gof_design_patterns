package com.ronaldsantos.feature.catalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CatalogScreen(
    openCart: () -> Unit,
    vm: CatalogViewModel = hiltViewModel()
) {
    val state by vm.state.collectAsState()

    LaunchedEffect(Unit) { vm.load() }

    Column {
        Button(onClick = openCart) { Text("Abrir carrinho") }
        LazyColumn(contentPadding = PaddingValues() ) {
            items(state.products) { p ->
                Text("${p.title} - R$ ${p.price}")
            }
        }
    }
}
