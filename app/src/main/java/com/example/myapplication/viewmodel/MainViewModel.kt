package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.myapplication.model.MainModel
import com.example.myapplication.model.ListModel
import com.example.myapplication.utlity.Dummyproductlist

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val sections : List<MainModel>
    get() = getSectionS()
     private fun getSectionS() : List<MainModel>{

         return  Dummyproductlist.getProduct1()
     }
    fun searchItems(searchString: String, subsections: ArrayList<ListModel>) : LiveData<ArrayList<ListModel>> = liveData {
        emit(subsections.filter {
            it.title.contains(searchString,true)
        } as ArrayList<ListModel>)
    }
}