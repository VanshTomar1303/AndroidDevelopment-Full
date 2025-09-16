package com.vansh.e_commerceappmvvm.data.mapper

import com.vansh.e_commerceappmvvm.data.remote.dto.CartDto
import com.vansh.e_commerceappmvvm.data.remote.dto.CartItemDto
import com.vansh.e_commerceappmvvm.data.remote.dto.ProductDto
import com.vansh.e_commerceappmvvm.data.remote.dto.RatingDto
import com.vansh.e_commerceappmvvm.domain.model.Cart
import com.vansh.e_commerceappmvvm.domain.model.CartItem
import com.vansh.e_commerceappmvvm.domain.model.Product
import com.vansh.e_commerceappmvvm.domain.model.Rating

object ProductMapper {
    fun productToDto(product: Product): ProductDto {
        return ProductDto(
            id = product.id,
            title = product.title,
            description = product.description,
            price = product.price,
            category = product.category,
            image = product.image,
            rating = RatingDto(
                rate = product.rating.rate,
                count = product.rating.count
            )
        )
    }
    fun dtoToProduct(productDto: ProductDto): Product {
        return Product(
            id = productDto.id,
            title = productDto.title,
            description = productDto.description,
            price = productDto.price,
            category = productDto.category,
            image = productDto.image,
            rating = Rating(
                rate = productDto.rating.rate,
                count = productDto.rating.count
            )
        )
    }

    fun cartDtoToCart(cartDto: CartDto): Cart {
        return Cart(
            id = cartDto.id,
            userId = cartDto.userId,
            date = cartDto.date,
            products = cartItemDtoToCartItem(cartDto.products),
            __v = cartDto.__v
        )
    }

    fun cartItemDtoToCartItem(cartItemDto: List<CartItemDto>): List<CartItem> {
        return cartItemDto.map { dto ->
            CartItem(
                productId = dto.productId,
                quantity = dto.quantity
            )
        }
    }

    fun cartToCartDto(cart: Cart): CartDto {
        return CartDto(
            id = cart.id,
            userId = cart.userId,
            date = cart.date,
            products = cartItemToCartItemDto(cart.products),
            __v = cart.__v
        )
    }

    fun cartItemToCartItemDto(cartItems: List<CartItem>): List<CartItemDto> {
        return cartItems.map { item ->
            CartItemDto(
                productId = item.productId,
                quantity = item.quantity
            )
        }
    }


}