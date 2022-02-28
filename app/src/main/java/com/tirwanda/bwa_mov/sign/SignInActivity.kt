package com.tirwanda.bwa_mov.sign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.*
import com.tirwanda.bwa_mov.R
import kotlinx.android.synthetic.main.activity_sign_in.*

import com.tirwanda.bwa_mov.HomeActivity
import com.tirwanda.bwa_mov.entity.User

class SignInActivity : AppCompatActivity() {
    lateinit var iUsername:String
    lateinit var iPassword:String

    lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        mDatabase = FirebaseDatabase.getInstance().getReference("User")

        btnSignIn.setOnClickListener {
            iUsername = etUsername.text.toString()
            iPassword = etPassword.text.toString()

            when {
                iUsername == "" -> {
                    etUsername.error = "Username is required"
                    etUsername.requestFocus()
                }
                iPassword == "" -> {
                    etPassword.error = "Password is required"
                    etPassword.requestFocus()
                }
                else -> {
                    pushLogin(iUsername, iPassword)
                }
            }
        }
    }

    private fun pushLogin(username: String, password: String) {
        mDatabase.child(username).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val user = dataSnapshot.getValue(User::class.java)

                if (user == null) {
                    Toast.makeText(this@SignInActivity, "Username or password is invalid",
                        Toast.LENGTH_LONG).show()
                } else {
                    if (user.password == password) {
                        val intent = Intent(this@SignInActivity, HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@SignInActivity, "Username or password is invalid",
                            Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@SignInActivity, databaseError.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}