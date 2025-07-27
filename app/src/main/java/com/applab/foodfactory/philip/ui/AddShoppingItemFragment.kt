package com.applab.foodfactory.philip.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.applab.foodfactory.R
import com.applab.foodfactory.databinding.FragmentAddShoppingItemBinding
import com.applab.foodfactory.philip.other.Status
import com.bumptech.glide.RequestManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AddShoppingItemFragment : Fragment(R.layout.fragment_add_shopping_item) {

    lateinit var viewModel: ShoppingViewModel
    private lateinit var binding: FragmentAddShoppingItemBinding
    @Inject lateinit var glide : RequestManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddShoppingItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ShoppingViewModel::class.java)

        subscribeToObservers()

        binding.apply {
            btnAddShoppingItem.setOnClickListener {
                viewModel.insertShoppingItem(
                    etShoppingItemName.text.toString(),
                    etShoppingItemAmount.text.toString(),
                    etShoppingItemPrice.text.toString()
                )
            }
            ivShoppingImage.setOnClickListener {
                findNavController().navigate(
                    AddShoppingItemFragmentDirections.actionAddShoppingItemFragmentToImagePickFragment()
                )
            }
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                viewModel.setCurImageUrl("")
                findNavController().popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }
    private fun subscribeToObservers() {
        viewModel.curImageUrl.observe(viewLifecycleOwner, Observer {
            glide.load(it).into(binding.ivShoppingImage)
        })
        viewModel.insertShoppingItemStatus.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let { result ->
                when(result.status) {
                    Status.SUCCESS -> {
                        Toast.makeText(context, "Added shopping item", Toast.LENGTH_SHORT).show()
                        findNavController().popBackStack()
                    }
                    Status.ERROR -> {
                        Toast.makeText(context, "Unknown error ${result.message}", Toast.LENGTH_SHORT).show()

                    }
                    Status.LOADING -> {
                        /* NO-OP */
                    }
                }
            }
        })
    }
}