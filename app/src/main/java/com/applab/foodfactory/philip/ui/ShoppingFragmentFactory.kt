/*
package com.applab.foodfactory.philip.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.applab.foodfactory.philip.adapters.ImageAdapter
import javax.inject.Inject

class ShoppingFragmentFactory @Inject constructor(
    private val imageAdapter: ImageAdapter
): FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className) {
            ImagePickFragment::class.java.name -> ImagePickFragment(imageAdapter)
            else -> super.instantiate(classLoader, className)
        }
    }
}*/

/*import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.androiddevs.shoppinglisttestingyt.adapters.ImageAdapter
import com.androiddevs.shoppinglisttestingyt.adapters.ShoppingItemAdapter
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class ShoppingFragmentFactory @Inject constructor(
    private val imageAdapter: ImageAdapter,
    private val glide: RequestManager,
    private val shoppingItemAdapter: ShoppingItemAdapter
): FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className) {
            ImagePickFragment::class.java.name -> ImagePickFragment(imageAdapter)
            AddShoppingItemFragment::class.java.name -> AddShoppingItemFragment(glide)
            ShoppingFragment::class.java.name -> ShoppingFragment(shoppingItemAdapter)
            else -> super.instantiate(classLoader, className)
        }
    }
}*/
