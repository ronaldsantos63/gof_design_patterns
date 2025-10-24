package com.ronaldsantos.core.data.repository

import com.ronaldsantos.core.data.datasource.LocalDataSource
import com.ronaldsantos.core.data.datasource.RemoteDataSource
import com.ronaldsantos.domain.repo.ProductRepository

class ProductRepositoryImpl(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource,
) : ProductRepository {
    override suspend fun getProducts() =
        local.cachedProducts().ifEmpty {
            val products = remote.products()
            local.saveProducts(products)
            products
        }
}
