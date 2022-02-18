package com.tirwanda.bwa_mov.onBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tirwanda.bwa_mov.R
import com.tirwanda.bwa_mov.sign.SignInActivity
import kotlinx.android.synthetic.main.activity_on_boarding_three.*

class OnBoardingThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_three)

        btnContinue.setOnClickListener {
            Intent(this, SignInActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}