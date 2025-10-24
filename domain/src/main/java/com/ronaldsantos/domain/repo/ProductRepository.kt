package com.ronaldsantos.domain.repo

import com.ronaldsantos.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>
}
