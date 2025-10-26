package com.ronaldsantos.core.data.datasource

import com.ronaldsantos.domain.model.Product
import javax.inject.Inject

interface LocalDataSource {
    suspend fun cachedProducts(): List<Product>
    suspend fun saveProducts(products: List<Product>)
}

class InMemoryLocalDataSource @Inject constructor(): LocalDataSource {
    private var productsCache: List<Product> = emptyList()

    override suspend fun cachedProducts(): List<Product> = productsCache

    override suspend fun saveProducts(products: List<Product>) {
        productsCache = products
    }
}
