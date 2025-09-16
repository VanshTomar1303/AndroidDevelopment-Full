package com.vansh.e_commerceappmvvm

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.vansh.e_commerceappmvvm.presentation.navigation.NavHostController
import com.vansh.e_commerceappmvvm.presentation.screens.cart.CartViewModel
import com.vansh.e_commerceappmvvm.presentation.screens.home.HomeScreen
import com.vansh.e_commerceappmvvm.presentation.screens.product_list.ProductListViewModel
import com.vansh.e_commerceappmvvm.presentation.screens.single_product.SingleProductViewModel
import com.vansh.e_commerceappmvvm.ui.theme.EcommerceAppMVVMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcommerceAppMVVMTheme {
                val productListViewModel = hiltViewModel<ProductListViewModel>()
                val productViewModel = hiltViewModel<SingleProductViewModel>()
                val cartViewModel = hiltViewModel<CartViewModel>()

                val productListState by productListViewModel.state.collectAsState()
                val singleProductState by productViewModel.state.collectAsState()
                val cartState by cartViewModel.state.collectAsState()

                NavHostController(
                    productListState = productListState,
                    singleProductState = singleProductState,
                    getProductById = productViewModel::getProductById,
                    cartState = cartState,
                    addToCart = productListViewModel::addToCart
                )
            }
        }
    }
}
