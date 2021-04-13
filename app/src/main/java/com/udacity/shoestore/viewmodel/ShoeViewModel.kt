package com.udacity.shoestore.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.BR
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel(), Observable {
    private val shoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    private val changeFieldRegistry = PropertyChangeRegistry()


    @Bindable
    var shoe = Shoe()
        set(value) {
            if (value != field) {
                field = value
                changeFieldRegistry.notifyChange(this, BR.shoe)
            }
        }

    fun getShoeList(): LiveData<MutableList<Shoe>> = shoeList

    fun addShoe(item: Shoe) {
        shoeList.value?.add(item)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        changeFieldRegistry.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        changeFieldRegistry.add(callback)
    }
}