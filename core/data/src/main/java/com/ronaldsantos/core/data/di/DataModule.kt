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
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides @Singleton fun provideApi(): ApiService = FakeApiService()

    @Provides @Singleton fun provideRemote(api: ApiService): RemoteDataSource =
        RemoteDataSourceImpl(api)
    @Provides @Singleton fun provideLocal(): LocalDataSource = InMemoryLocalDataSource()

    @Provides @Singleton fun provideProductRepo(
        remote: RemoteDataSource,
        local: LocalDataSource,
    ): ProductRepository = ProductRepositoryImpl(remote, local)

    @Provides @Singleton fun provideAuthRepo(
        remote: RemoteDataSource,
    ): AuthRepository = AuthRepositoryImpl(remote)
}
