package com.abadock.probafirebase.objectList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.abadock.probafirebase.Recycler.MobleAdapter
import com.abadock.probafirebase.Recycler.MobleModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ObjectsListViewModel : ViewModel() {

    private var _mobles: MutableLiveData<List<MobleModel>> =MutableLiveData<List<MobleModel>>()
    val mobles: LiveData<List<MobleModel>> = _mobles

    fun getAdapter(nav: NavController): MobleAdapter? {

        return _mobles.value?.let { MobleAdapter(it, nav) }

    }

    fun getMobles() {

        val db = Firebase.firestore

        val lista: MutableList<MobleModel> = mutableListOf()


        db.collection("bd").get().addOnSuccessListener  {
                data -> for (document in data) {
                    Log.d("PENDEJOS", document.id)
                    lista.add(MobleModel(document.id, document.data["nom"].toString(), document.data["preu"].toString().toDouble()))
                }
        }.addOnCompleteListener {
            _mobles.value = lista
        }

    }
}