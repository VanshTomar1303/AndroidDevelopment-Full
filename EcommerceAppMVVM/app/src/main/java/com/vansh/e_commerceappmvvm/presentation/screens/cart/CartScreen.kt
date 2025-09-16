package com.vansh.e_commerceappmvvm.presentation.screens.cart

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.vansh.e_commerceappmvvm.presentation.component.ProductCard
import com.vansh.e_commerceappmvvm.ui.theme.Green400
import com.vansh.e_commerceappmvvm.ui.theme.Green800
import com.vansh.e_commerceappmvvm.ui.theme.Green900


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CartScreen(
    cartState: CartState,
    navController: NavHostController,
    getProductById: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.9f)
            .background(Green900),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        LazyColumn(
            modifier = Modifier.fillMaxSize(0.92f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           items(cartState.productList) {
                item -> ProductCard(
               product = item,
               navController = navController,
               getProductById = getProductById
           )
           }
        }
        Row(
            modifier = Modifier.fillMaxWidth()
                .height(200.dp)
                .background(Green800)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "$${cartState.totalAmount}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Green400
            )
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Green400,
                    contentColor = Green900
                )
            ) {
                Text(
                    text = "Buy",
                    fontSize = 20.sp
                )
            }
        }
    }
}