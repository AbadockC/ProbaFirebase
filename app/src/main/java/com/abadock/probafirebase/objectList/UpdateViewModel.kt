package com.abadock.probafirebase.objectList

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.abadock.probafirebase.R
import com.abadock.probafirebase.Recycler.MobleModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class UpdateViewModel : ViewModel() {


    companion object {

    var selectedMoble: MobleModel = MobleModel("a","a", 1.0)

    fun selectMoble(moble: MobleModel){
        selectedMoble = moble
    }


    }

    fun deleteProduct(nav: NavController, ctx: Context){
        val db = Firebase.firestore



        db.collection("bd").document(selectedMoble.docid).delete()
            .addOnSuccessListener {
                nav.navigate(R.id.action_updateFragment_to_objectsListFragment)
            }
            .addOnFailureListener {
                Toast.makeText(ctx, "No s'ha pogut eliminar", Toast.LENGTH_SHORT).show()
            }
    }

    fun updateProduct(docid: String) {

    }
}