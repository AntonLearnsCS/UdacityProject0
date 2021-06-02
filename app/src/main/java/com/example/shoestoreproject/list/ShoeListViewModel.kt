package com.example.shoestoreproject.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel(saved : Boolean) : ViewModel() {
    var tempVar = LiveDataClass()

    private var _array : MutableLiveData<MutableList<LiveDataClass>>//MutableList<LiveDataClass>
    val array : LiveData<MutableList<LiveDataClass>>
    get() = _array

    private val _counter : MutableLiveData<Int> = MutableLiveData()
    val counter : LiveData<Int>
    get() = _counter

    private var _returning : MutableLiveData<Boolean> = MutableLiveData()//MutableList<LiveDataClass>
    val returning : LiveData<Boolean>
        get() = _returning

    private var _id : MutableLiveData<Int> = MutableLiveData()//MutableList<LiveDataClass>
    val id : LiveData<Int>
        get() = _id

    private val _saved = MutableLiveData<Boolean>()
    val saved : LiveData<Boolean>
    get() = _saved

    //Q: Why can't you reference the mutableList object "array" outside of a method?

    init {
        _saved.value = saved
        _array = MutableLiveData(mutableListOf<LiveDataClass>())//MutableLiveData() //Collection<LiveDataClass>
        _counter.value = 0
        _returning.value = false
    }
    fun setReturnTrue()
    {
        _returning.value = true
    }
    fun setReturnFalse()
    {
        _returning.value = false
    }
    fun createObject()
    {
        //pass in the information from custom_detail to here
        var myObject = LiveDataClass()
        tempVar = myObject

        _array.value?.add(myObject)

        _counter.value = _counter.value?.plus(1)
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
    fun setBooleanTrue()
    {
        _saved.value = true
    }
    fun setId(value : Int)
    {
        _id.value = value
    }

}

