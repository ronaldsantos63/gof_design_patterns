package com.ronaldsantos.feature.auth

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AuthScreen(
    onLoggedIn: () -> Unit,
    vm: AuthViewModel = hiltViewModel()
) {
    Button(onClick = {
        vm.doLogin("ronald@example.com", "1234")
        onLoggedIn()
    }) {
        Text("Login")
    }
}
