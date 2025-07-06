package com.applab.foodfactory.xmll

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.applab.foodfactory.R
import com.applab.foodfactory.databinding.FragmentFirstBinding
import com.applab.foodfactory.xmll.vm.LoginVm

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val vm by viewModels<LoginVm>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
        binding.buttonFirst.setOnClickListener {
            /*vm.login(
                _binding?.etUname?.text?.trim().toString(),
                _binding?.etPassword?.text?.trim().toString()
            )*/
            findNavController().navigate(R.id.SecondFragment)
        }
    }

    fun setObserver() {
        vm.loginResult.observe(viewLifecycleOwner) {
            _binding?.result?.text = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}