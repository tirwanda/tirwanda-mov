package com.tirwanda.bwa_mov.onBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tirwanda.bwa_mov.R
import kotlinx.android.synthetic.main.activity_on_boarding_two.*

class OnBoardingTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_two)

        btnContinue.setOnClickListener {
            Intent(this, OnBoardingThreeActivity::class.java).also {
                startActivity(it)
            }
        }

        btnBack.setOnClickListener {
            finish()
            super.onBackPressed()
        }
    }
}