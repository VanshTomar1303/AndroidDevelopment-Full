package com.vansh.e_commerceappmvvm.presentation.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.vansh.e_commerceappmvvm.domain.model.Cart
import com.vansh.e_commerceappmvvm.presentation.screens.cart.CartScreen
import com.vansh.e_commerceappmvvm.presentation.screens.cart.CartState
import com.vansh.e_commerceappmvvm.presentation.screens.product_list.ProductListScreen
import com.vansh.e_commerceappmvvm.presentation.screens.product_list.ProductListState
import com.vansh.e_commerceappmvvm.ui.theme.Black
import com.vansh.e_commerceappmvvm.ui.theme.Green200
import com.vansh.e_commerceappmvvm.ui.theme.Green900

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    getProductById: (Int) -> Unit,
    navController: NavHostController,
    state: ProductListState,
    cartState: CartState,
    addToCart: (Cart) -> Unit
) {
    var index by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        containerColor = Black,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Cart App",
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Green900,
                    titleContentColor = Green200
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Green900,
                content = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        IconButton(
                            onClick = {
                                index = 0
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Home",
                                tint = Green200,
                                modifier = Modifier.size(30.dp)
                            )
                        }

                        IconButton(
                            onClick = {
                                index = 1
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = "Cart",
                                tint = Green200,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                }
            )
        }
    ) {it ->
        when(index){
            0 -> {
                ProductListScreen(
                    it,
                    state = state,
                    navController = navController,
                    getProductById = getProductById,
                    addToCart = addToCart
                )
            }
            1 -> {
                CartScreen(
                    cartState = cartState,
                    navController = navController,
                    getProductById = getProductById,
                )
            }
        }
    }
}