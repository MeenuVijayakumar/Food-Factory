package com.applab.foodfactory.listusinghilt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.applab.foodfactory.R
import com.applab.foodfactory.databinding.FragmentMovieListBinding
import com.applab.foodfactory.listusinghilt.adapter.MovieListAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieListFragment : Fragment() {
    private lateinit var binding: FragmentMovieListBinding
    @Inject
    lateinit var movieAdapter : MovieListAdapter
    /* // TODO: Rename and change types of parameters
     private var param1: String? = null
     private var param2: String? = null

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         arguments?.let {
             param1 = it.getString(ARG_PARAM1)
             param2 = it.getString(ARG_PARAM2)
         }
     }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViews()
    }

    private fun setUpViews() {
        binding.apply {
            rvMovieList.adapter = movieAdapter
        }

    }

    /*  companion object {
          */
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MovieListFragment.
     *//*
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MovieListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}