package com.ronaldsantos.domain.usecase

import com.ronaldsantos.domain.model.Product
import com.ronaldsantos.domain.repo.ProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val repo: ProductRepository) {
    suspend operator fun invoke(): List<Product> = repo.getProducts()
}
