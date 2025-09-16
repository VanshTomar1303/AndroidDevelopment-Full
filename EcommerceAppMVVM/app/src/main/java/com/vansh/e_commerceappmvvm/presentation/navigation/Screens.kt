package com.vansh.e_commerceappmvvm.presentation.navigation

import com.vansh.e_commerceappmvvm.domain.model.Product
import kotlinx.serialization.Serializable

sealed interface Screens {
    @Serializable
    object ProductListScreen: Screens
    @Serializable
    object SingleProductScreen: Screens
}