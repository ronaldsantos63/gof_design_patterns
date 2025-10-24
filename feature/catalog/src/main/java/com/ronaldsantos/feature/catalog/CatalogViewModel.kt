package com.ronaldsantos.feature.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ronaldsantos.domain.model.Product
import com.ronaldsantos.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CatalogUiState(
    val products: List<Product> = emptyList(),
)

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val getProducts: GetProductsUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(CatalogUiState())
    val state: StateFlow<CatalogUiState> = _state

    fun load() {
        viewModelScope.launch {
            _state.value = CatalogUiState(
                products = getProducts()
            )
        }
    }
}

