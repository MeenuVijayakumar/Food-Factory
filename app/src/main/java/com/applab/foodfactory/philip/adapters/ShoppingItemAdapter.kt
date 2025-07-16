package com.applab.foodfactory.philip.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.applab.foodfactory.databinding.ItemShoppingBinding
import com.applab.foodfactory.philip.data.local.ShoppingItem
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class ShoppingItemAdapter @Inject constructor(
    private val glide: RequestManager
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingItemViewHolder>() {

    inner class ShoppingItemViewHolder(val itemView: ItemShoppingBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        fun bind(shoppingItem: ShoppingItem) {
            itemView.apply {
                glide.load(shoppingItem.imageUrl).into(ivShoppingImage)

                tvName.text = shoppingItem.name
                val amountText = "${shoppingItem.amount}x"
                tvShoppingItemAmount.text = amountText
                val priceText = "${shoppingItem.price}€"
                tvShoppingItemPrice.text = priceText
            }
        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<ShoppingItem>() {
        override fun areItemsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var shoppingItems: List<ShoppingItem>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        return ShoppingItemViewHolder(
            ItemShoppingBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        )
    }

    override fun getItemCount(): Int {
        return shoppingItems.size
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        val shoppingItem = shoppingItems[position]
        holder.bind(shoppingItem)
    }
}