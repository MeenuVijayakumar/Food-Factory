package com.applab.foodfactory.philip.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.applab.foodfactory.databinding.ItemImageBinding
import com.bumptech.glide.RequestManager
import javax.inject.Inject


class ImageAdapter @Inject constructor(
    private val glide: RequestManager
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
   inner class ImageViewHolder(val itemView: ItemImageBinding): RecyclerView.ViewHolder(itemView.root) {
        fun bind(url: String, glide: RequestManager) {

            itemView.apply {
                glide.load(url).into(ivShoppingImage)

                root.setOnClickListener {
                    onItemClickListener?.let { click ->
                        click(url)
                    }
                }
            }
        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var images: List<String>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemImageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }



    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
       holder.bind(images[position],glide)
    }

    override fun getItemCount(): Int {
        return images.size
    }
    private var onItemClickListener: ((String) -> Unit)? = null

    fun setOnItemClickListener(listener: (String) -> Unit) {
        onItemClickListener = listener
    }
}
















