package com.ronaldsantos.core.common

data class AppError(
    val code: String,
    val message: String,
    val cause: Throwable? = null
)
