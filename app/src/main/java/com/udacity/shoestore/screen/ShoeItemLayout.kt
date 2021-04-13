package com.udacity.shoestore.screen

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ItemShoeListBinding
import com.udacity.shoestore.models.Shoe


class ShoeItemLayout: LinearLayout {
    constructor(context: Context) : super(context)

    private val binding: ItemShoeListBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_shoe_list, this, false)

    fun loadShoe(shoe: Shoe) {
        binding.apply {
            addView(this.root)
            binding.data=shoe
        }
    }
}