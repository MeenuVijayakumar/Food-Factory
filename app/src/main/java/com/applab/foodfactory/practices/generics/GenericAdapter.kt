package com.applab.foodfactory.practices.generics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applab.foodfactory.databinding.ItemGenericBinding
import com.applab.foodfactory.utils.setCornerRadius
import com.applab.foodfactory.utils.toPx
import com.applab.foodfactory.xmll.Fruit

class GenericAdapter<T>(val list: List<T>) :
    RecyclerView.Adapter<GenericAdapter<T>.GenericViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenericViewHolder {
        return GenericViewHolder(
            ItemGenericBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class GenericViewHolder(val binding: ItemGenericBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: T) {
            when (item) {
                is Fruit -> {
                    binding.genericTitle.text = item.name
                    binding.genericDescription.text = item.description
                    binding.image.setCornerRadius(50f.toPx())
                }
            }

        }
    }

}