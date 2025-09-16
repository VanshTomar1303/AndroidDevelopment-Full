package com.vansh.e_commerceappmvvm.presentation.screens.single_product

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.vansh.e_commerceappmvvm.R
import com.vansh.e_commerceappmvvm.domain.model.Cart
import com.vansh.e_commerceappmvvm.domain.model.CartItem
import com.vansh.e_commerceappmvvm.ui.theme.Green400
import com.vansh.e_commerceappmvvm.ui.theme.Green600
import com.vansh.e_commerceappmvvm.ui.theme.Green700
import com.vansh.e_commerceappmvvm.ui.theme.Green800
import com.vansh.e_commerceappmvvm.ui.theme.Green900
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SingleProductScreen(
    singleProductState: SingleProductState,
    onBack: () -> Unit,
    addToCart: (Cart) -> Unit
) {
        val product = singleProductState.product

        Box(
            modifier = Modifier.fillMaxSize()
                .background(Green900),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .align(Alignment.TopStart)
                    .background(Green800),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        onBack()
                    }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back To Home Page",
                        tint = Green400
                    )
                }
                Text(
                    text = "Product",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Green400
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                AsyncImage(
                    modifier = Modifier.size(300.dp),
                    model = product.image,
                    contentDescription = "product"
                )
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = product.title,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Green700
                )

                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = product.description,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Green400
                )
                Spacer(modifier = Modifier.height(60.dp))
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .align(Alignment.End),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "$${product.price}",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Green600
                    )
                    Button(
                        onClick = {
                            addToCart(
                                Cart(
                                    id = 1,
                                    userId = 1,
                                    date = LocalDateTime.now().toString(),
                                    products = mutableListOf(
                                        CartItem(
                                            productId = product.id,
                                            quantity = 1
                                        )
                                    ),
                                    __v = 0
                                )
                            )
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Green400,
                            contentColor = Green900
                        )
                    ) {
                        Text(
                            text = "Add To Cart",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }
}

