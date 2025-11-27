package com.example.myapplication

sealed class ListItem {
    data class UserItem(val user: User) : ListItem()
    data class ProductItem(val product: Product) : ListItem()
    data class HeaderItem(val title: String) : ListItem()
    data class ProductCarouselItem(val products: List<Product>) : ListItem()
}