package com.abadock.probafirebase.objectList

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.abadock.probafirebase.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class InsertViewModel : ViewModel() {
    fun newMoble(nom: String, preu: Double, navigator: NavController, ctx: Context) {

        val db = Firebase.firestore

        val data = hashMapOf(
            "nom" to nom,
            "preu" to preu
        )

        db.collection("bd").add(data).addOnSuccessListener {
            navigator.navigate(R.id.action_insertFragment_to_objectsListFragment)
        }.addOnFailureListener{
            Toast.makeText(ctx, "No s'ha pogunt inserir", Toast.LENGTH_SHORT).show()
        }
    }
}