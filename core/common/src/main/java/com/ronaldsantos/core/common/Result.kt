package com.ronaldsantos.core.common

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val exception: AppError) : Result<Nothing>()
}
