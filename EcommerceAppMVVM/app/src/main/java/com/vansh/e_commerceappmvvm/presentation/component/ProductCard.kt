package com.vansh.e_commerceappmvvm.presentation.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.vansh.e_commerceappmvvm.domain.model.Cart
import com.vansh.e_commerceappmvvm.domain.model.CartItem
import com.vansh.e_commerceappmvvm.domain.model.Product
import com.vansh.e_commerceappmvvm.presentation.navigation.Screens
import com.vansh.e_commerceappmvvm.ui.theme.DarkGreen
import com.vansh.e_commerceappmvvm.ui.theme.Green300
import com.vansh.e_commerceappmvvm.ui.theme.Green400
import com.vansh.e_commerceappmvvm.ui.theme.Green600
import com.vansh.e_commerceappmvvm.ui.theme.Green900
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProductCard(
    product: Product,
    navController: NavController,
    getProductById: (Int) -> Unit,
    addToCart: (Cart) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable{
                getProductById(product.id)
                navController.navigate(Screens.SingleProductScreen)
            }
            .clip(RoundedCornerShape(10.dp))
            .border(width = 1.dp, color = Green300, shape = RoundedCornerShape(10.dp)),
        colors = CardDefaults.cardColors(
            containerColor = DarkGreen
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = "Product Image",
                modifier = Modifier.size(150.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(top = 30.dp),
                    text = product.title,
                    fontSize = 16.sp,
                    color = Green600
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(40.dp)
                ) {
                    Text(
                        text = "$${product.price}",
                        fontSize = 16.sp,
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
                            text = "Add To Cart"
                        )
                    }
                }
            }
        }
    }

}