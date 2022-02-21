package com.tirwanda.bwa_mov.sign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tirwanda.bwa_mov.R
import kotlinx.android.synthetic.main.activity_sign_in.*
import com.google.firebase.database.DatabaseReference

import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        btnSignIn.setOnClickListener {
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("message")

            myRef.setValue("Hello, World!")
        }
    }
}