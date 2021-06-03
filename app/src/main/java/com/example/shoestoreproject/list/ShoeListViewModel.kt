package com.example.shoestoreproject.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel() : ViewModel() {
    //to access the newly created "LiveDataClass"
    var tempVar = LiveDataClass()

    //encapsulation
    private var _array : MutableLiveData<MutableList<LiveDataClass>>//MutableList<LiveDataClass>
    val array : LiveData<MutableList<LiveDataClass>>
    get() = _array

    private var _returning : MutableLiveData<Boolean> = MutableLiveData()//MutableList<LiveDataClass>
    val returning : LiveData<Boolean>
        get() = _returning

    private var _id : MutableLiveData<Int> = MutableLiveData()//MutableList<LiveDataClass>
    val id : LiveData<Int>
        get() = _id



    //Q: Why can't you reference the mutableList object "array" outside of a method?

    init {
        _array = MutableLiveData(mutableListOf())//MutableLiveData() //Collection<LiveDataClass>
        _returning.value = false
    }

    fun createObject()
    {
        //pass in the information from custom_detail to here
        var myObject = LiveDataClass()
        tempVar = myObject

        _array.value?.add(myObject)
    }

    class LiveDataClass()
    {
        var _companyName = MutableLiveData<String>()
        var _shoeName = MutableLiveData<String>()
        var _shoeSize = MutableLiveData<String>()
        var _shoeDescription = MutableLiveData<String>()

    }

    fun assignCompanyName(name : String)
    {
        tempVar._companyName.value = name
    }
    fun assignShoeName(name : String)
    {
        tempVar._shoeName.value = name
    }
    fun assignShoeSize(size : String)
    {
        tempVar._shoeSize.value = size
    }
    fun assignShoeDescription(name : String)
    {
        tempVar._shoeDescription.value = name
    }



    fun setId(value : Int)
    {
        _id.value = value
    }
    fun setReturnTrue()
    {
        _returning.value = true
    }
    fun setReturnFalse()
    {
        _returning.value = false
    }
}

