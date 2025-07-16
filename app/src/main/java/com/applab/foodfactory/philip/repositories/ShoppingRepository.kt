package com.applab.foodfactory.philip.repositories

import androidx.lifecycle.LiveData

import com.applab.foodfactory.philip.data.local.ShoppingItem
import com.applab.foodfactory.philip.data.remote.responses.ImageResponse
import com.applab.foodfactory.philip.other.Resource
import retrofit2.Response

interface ShoppingRepository {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>
}