package com.ronaldsantos.domain.usecase

import com.ronaldsantos.domain.model.Product
import com.ronaldsantos.domain.repo.ProductRepository

class GetProductsUseCase(private val repo: ProductRepository) {
    suspend operator fun invoke(): List<Product> = repo.getProducts()
}
