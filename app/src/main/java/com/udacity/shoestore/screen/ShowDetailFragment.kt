package com.udacity.shoestore.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeViewModel

class ShowDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.lifecycleOwner = this
        binding.shoeViewModel = shoeViewModel
        binding.shoe = Shoe()
        binding.btnCancel.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_showDetailFragment_to_shoeListFragment)
        }

        binding.btnSave.setOnClickListener {
            var shoe = Shoe(
                binding.etShoeName.text.toString(),
                binding.etShoeSize.text.toString().toDouble(),
                binding.etComName.text.toString(),
                binding.etDesc.text.toString()
            )
            shoeViewModel.addShoe(shoe)
            view?.findNavController()?.navigate(R.id.action_showDetailFragment_to_shoeListFragment)

        }

        return binding.root
    }
}