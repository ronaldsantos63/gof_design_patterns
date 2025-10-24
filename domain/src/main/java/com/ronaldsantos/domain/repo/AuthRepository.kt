package com.ronaldsantos.domain.repo

import com.ronaldsantos.domain.model.User

interface AuthRepository {
    suspend fun login(email: String, password: String): User
}
