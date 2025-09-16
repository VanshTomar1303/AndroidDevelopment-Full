package com.vansh.e_commerceappmvvm.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vansh.e_commerceappmvvm.domain.model.Cart
import com.vansh.e_commerceappmvvm.presentation.screens.cart.CartState
import com.vansh.e_commerceappmvvm.presentation.screens.home.HomeScreen
import com.vansh.e_commerceappmvvm.presentation.screens.product_list.ProductListState
import com.vansh.e_commerceappmvvm.presentation.screens.single_product.SingleProductScreen
import com.vansh.e_commerceappmvvm.presentation.screens.single_product.SingleProductState

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavHostController(
    productListState: ProductListState,
    singleProductState: SingleProductState,
    getProductById: (Int) -> Unit,
    cartState: CartState,
    addToCart: (Cart) -> Unit
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.ProductListScreen
    ){
        composable<Screens.ProductListScreen> {
            HomeScreen(
                state = productListState,
                navController = navController,
                getProductById = getProductById,
                cartState = cartState,
                addToCart = addToCart
            )
        }

        composable<Screens.SingleProductScreen> {
            SingleProductScreen(
                singleProductState = singleProductState,
                onBack = {
                    navController.popBackStack()
                },
                addToCart = addToCart
            )
        }
    }
}