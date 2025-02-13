package com.applab.foodfactory.ui.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class HomeVm :ViewModel(){
    private val _listItems = getDummyListData().toMutableStateList()
    val listItems :List<DummyItem>
        get() = _listItems

    fun removeDummyItem(item: DummyItem) {
        _listItems.remove(item)
    }
    fun onCheckItem(item:DummyItem,isCheck:Boolean) {
       _listItems.find { it.id == item.id }?.checked = isCheck
    }
}

fun getDummyListData()= List(30) {idx->DummyItem(idx,"Dummy Data #$idx")}
class DummyItem(val id:Int,val label:String,initialState:Boolean=false){
    var checked by mutableStateOf(initialState)
}