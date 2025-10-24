package com.ronaldsantos.core.data.repository

import com.ronaldsantos.core.data.datasource.RemoteDataSource
import com.ronaldsantos.domain.repo.AuthRepository

class AuthRepositoryImpl(
    private val remote: RemoteDataSource,
) : AuthRepository {
    override suspend fun login(email: String, password: String) =
        remote.login(email, password)
}
