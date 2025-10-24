package com.ronaldsantos.core.data.datasource

import com.ronaldsantos.core.data.remote.ApiService
import com.ronaldsantos.domain.model.Product
import com.ronaldsantos.domain.model.User

interface RemoteDataSource {
    suspend fun products(): List<Product>
    suspend fun login(email: String, password: String): User
}

class RemoteDataSourceImpl(
    private val api: ApiService
) : RemoteDataSource {
    override suspend fun products(): List<Product> = api.fetchProducts()

    override suspend fun login(email: String, password: String): User = api.login(email, password)
}
