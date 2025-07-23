package com.applab.foodfactory.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn

class DashboardViewModel : ViewModel() {

    private val _searchQuery = MutableStateFlow<String>("")
    val searchQuery: StateFlow<String> = _searchQuery

    val resultForSearch: StateFlow<List<String>> = _searchQuery
        // .filter { it.isNotEmpty() } // this check prevents the removal of old values in the result  after deleting the search value
        .flatMapLatest {
            if (it.isEmpty())
                flowOf(emptyList())
            else
                fetchSearchResult(it)
        }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val userList: StateFlow<List<Product>> = combine(
        getNames(), getPrice(), getQuantity()
    ) { names, prices, quantity ->
        val minSize = minOf(names.size, prices.size, quantity.size)
        List(minSize) {
            Product(name = names[it], price = prices[it], quantity = quantity[it])
        }
    }.stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    fun updateSearchQuery(str: String) {
        _searchQuery.value = str
    }

    fun fetchSearchResult(query: String) = flow {
        delay(3000L)
        emit(List(4) { "Search result for $query" })
    }

    fun getNames() = flow {
        delay(1000)
        emit(listOf<String>("Apple", "Bag", "Cap"))
    }

    fun getPrice() = flow {
        delay(2000)
        emit(listOf<Int>(20, 30, 40))
    }

    fun getQuantity() = flow {
        delay(3000)
        emit(listOf<String>("200", "190", "400"))
    }
}

data class Product(
    val name: String,
    val price: Int,
    val quantity: String
)