package com.vansh.e_commerceappmvvm.presentation.screens.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vansh.e_commerceappmvvm.domain.model.Cart
import com.vansh.e_commerceappmvvm.domain.model.Product
import com.vansh.e_commerceappmvvm.domain.usecase.EcommerceUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val useCases: EcommerceUseCases
): ViewModel() {
    private val _state = MutableStateFlow(CartState())
    val state: StateFlow<CartState> = _state

    init {
        loadCart()
    }

    fun loadCart() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            try {
                val cartList = useCases.getFullCart()

                _state.update {
                    it.copy(
                        isLoading = false,
                        cartList = cartList,
                        error = null
                    )
                }

                // Now load products after cart is set
                loadProductFromCart(cartList)

            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = e.message
                    )
                }
            }
        }
    }

    private fun loadProductFromCart(cartList: List<Cart>) {
        viewModelScope.launch {
            try {
                val products: List<Product> = cartList.flatMap { cart ->
                    cart.products.map { cartItem ->
                        useCases.getProductById(cartItem.productId)
                    }
                }

                val amount = products.sumOf { it.price }

                _state.update {
                    it.copy(
                        isLoading = false,
                        error = null,
                        productList = products,
                        totalAmount = amount
                    )
                }

                loadCart()

            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = e.message
                    )
                }
            }
        }
    }
}
