package com.applab.foodfactory.practices.generics

open class Item(val name: String)
class BookItem(name: String) : Item(name) {
    fun displayBookDetails() {
        println("Displaying book details: $name")
    }
}
class MovieItem(name: String) : Item(name) {
    fun playMovie() {
        println("Playing movie: $name")
    }
}
class Adapter {
    fun bindItem(item: Item) {
        if (item is BookItem) {
            val bookItem = item
            bookItem.displayBookDetails() // Type-specific method call
        } else if (item is MovieItem) {
            val movieItem = item
            movieItem.playMovie() // Type-specific method call
        }
    }
}
fun main() {
    val adapter = Adapter()
    val items: List<Item> = listOf(BookItem("Harry Potter"), MovieItem("The Avengers"))
    for (item in items) {
        adapter.bindItem(item)
    }
}