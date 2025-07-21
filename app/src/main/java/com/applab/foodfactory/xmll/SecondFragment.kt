package com.applab.foodfactory.xmll

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.applab.foodfactory.R
import com.applab.foodfactory.databinding.FragmentSecondBinding
import com.applab.foodfactory.practices.generics.GenericAdapter

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvFruits.adapter = GenericAdapter(MutableList(20) {
                Fruit(
                    "Mango",
                    getString(R.string.lorem_ipsum))
            })
        }
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.thirdFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

data class Fruit(
    val name: String,
    val description: String
)