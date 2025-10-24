package com.ronaldsantos.feature.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ronaldsantos.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val login: LoginUseCase
) : ViewModel() {
    fun doLogin(email: String, password: String) {
        viewModelScope.launch {
            login(email, password)
        }
    }
}
