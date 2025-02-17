package com.abadock.probafirebase.login

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.abadock.probafirebase.SecondActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginViewModel : ViewModel() {
    private lateinit var auth: FirebaseAuth

    fun login(mail: String, pass: String, ctx: Context, button: Button) {

        button.setEnabled(false)

        auth = Firebase.auth

        auth.signInWithEmailAndPassword(mail, pass)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {

                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser

                    val myIntent: Intent = Intent(ctx, SecondActivity::class.java)
                    ctx.startActivity(myIntent)

                } else {

                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(ctx, "Register incorrecte failed.", Toast.LENGTH_SHORT).show()
                    button.setEnabled(true)
                }
            }
    }
}