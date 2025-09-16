package com.vansh.e_commerceappmvvm.presentation.screens.single_product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vansh.e_commerceappmvvm.domain.usecase.EcommerceUseCases
import com.vansh.e_commerceappmvvm.domain.usecase.GetProductByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingleProductViewModel @Inject constructor(
    private val useCase: EcommerceUseCases
): ViewModel() {

    private val _state = MutableStateFlow(SingleProductState())
    val state: StateFlow<SingleProductState> = _state

    fun getProductById(id: Int){
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }

            try {
                val products = useCase.getProductById(id)

                _state.update {
                    it.copy(
                        isLoading = false,
                        product = products,
                        error = null
                    )
                }

            } catch (e: Exception){
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