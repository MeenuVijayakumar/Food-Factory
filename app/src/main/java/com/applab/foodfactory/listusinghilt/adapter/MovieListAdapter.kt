package com.applab.foodfactory.listusinghilt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applab.foodfactory.R
import com.applab.foodfactory.databinding.ItemMovieItemBinding
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class MovieListAdapter @Inject constructor(
    private val glide: RequestManager
) : RecyclerView.Adapter<MovieListAdapter.MovieHolder>() {

    val list = movieList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(
            ItemMovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {

        holder.bind(list[position])
    }

    inner class MovieHolder(val binding: ItemMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(s: MovieItemDummy) {
            binding.movieName.text = s.name
            glide.load(s.image).into(binding.movieImage)
        }

    }
}

data class MovieItemDummy(
    val name: String,
    val image: Int
)

val movieList = listOf(
    MovieItemDummy("Adapter Title1", R.drawable.image),
    MovieItemDummy("Adapter Title2", R.drawable.image_home_banner),
    MovieItemDummy("Adapter Title3", R.drawable.image_home_banner),
)