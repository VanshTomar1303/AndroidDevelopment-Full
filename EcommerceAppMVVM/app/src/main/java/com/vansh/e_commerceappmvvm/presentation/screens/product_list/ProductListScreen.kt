package com.vansh.e_commerceappmvvm.presentation.screens.product_list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vansh.e_commerceappmvvm.domain.model.Cart
import com.vansh.e_commerceappmvvm.presentation.component.ProductCard

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProductListScreen(
    values: PaddingValues,
    state: ProductListState,
    navController: NavController,
    getProductById: (Int) -> Unit,
    addToCart: (Cart) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(values)
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(state.productList) { item ->
            ProductCard(
                product = item,
                navController = navController,
                getProductById = getProductById,
                addToCart = addToCart
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}