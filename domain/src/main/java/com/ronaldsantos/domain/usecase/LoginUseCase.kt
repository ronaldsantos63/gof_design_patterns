package com.ronaldsantos.domain.usecase

import com.ronaldsantos.domain.model.User
import com.ronaldsantos.domain.repo.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repo: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): User =
        repo.login(email, password)
}
