package com.abadock.probafirebase.objectList

import androidx.lifecycle.ViewModel
import com.abadock.probafirebase.Recycler.MobleAdapter
import com.abadock.probafirebase.Recycler.MobleModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ObjectsListViewModel : ViewModel() {

    fun getAdapter(): MobleAdapter {
        val db = Firebase.firestore

        val lista: MutableList<MobleModel> = mutableListOf()


        db.collection("bd").get().addOnSuccessListener  {
            data -> for (document in data) {
                lista.add(MobleModel(document.data["nom"].toString(), document.data["preu"].toString().toInt()))
        }
        }

        return MobleAdapter(lista)

    }

}