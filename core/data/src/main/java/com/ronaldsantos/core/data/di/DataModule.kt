package com.ronaldsantos.core.data.di

import com.ronaldsantos.core.data.datasource.InMemoryLocalDataSource
import com.ronaldsantos.core.data.datasource.LocalDataSource
import com.ronaldsantos.core.data.datasource.RemoteDataSource
import com.ronaldsantos.core.data.datasource.RemoteDataSourceImpl
import com.ronaldsantos.core.data.remote.ApiService
import com.ronaldsantos.core.data.remote.FakeApiService
import com.ronaldsantos.core.data.repository.AuthRepositoryImpl
import com.ronaldsantos.core.data.repository.ProductRepositoryImpl
import com.ronaldsantos.domain.repo.AuthRepository
import com.ronaldsantos.domain.repo.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindApiService(
        impl: FakeApiService,
    ): ApiService

    @Binds
    fun bindRemoteDataSource(
        impl: RemoteDataSourceImpl,
    ): RemoteDataSource

    @Binds
    fun bindLocalDataSource(
        impl: InMemoryLocalDataSource,
    ): LocalDataSource

    @Binds
    fun bindProductRepository(
        impl: ProductRepositoryImpl,
    ): ProductRepository

    @Binds
    fun bindAuthRepository(
        impl: AuthRepositoryImpl,
    ): AuthRepository
}
