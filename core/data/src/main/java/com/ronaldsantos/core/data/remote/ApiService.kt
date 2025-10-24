package com.ronaldsantos.core.data.remote

import com.ronaldsantos.domain.model.Product
import com.ronaldsantos.domain.model.User

interface ApiService {
    suspend fun fetchProducts(): List<Product>
    suspend fun login(email: String, password: String): User
}

class FakeApiService : ApiService {
    override suspend fun fetchProducts(): List<Product> =
        listOf(Product("1", "Camisa Kotlin", 99.9), Product("2", "Caneca Compose", 59.9))

    override suspend fun login(email: String, password: String): User =
        User(id = "u-1", email = email)
}
