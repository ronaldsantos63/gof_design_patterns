package com.ronaldsantos.domain.usecase

import com.ronaldsantos.domain.model.User
import com.ronaldsantos.domain.repo.AuthRepository

class LoginUseCase(private val repo: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): User =
        repo.login(email, password)
}
