package com.addincendekia.bwa_mov.onboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.addincendekia.bwa_mov.R
import com.addincendekia.bwa_mov.auth.SigninActivity
import com.addincendekia.bwa_mov.utils.UserPreferences
import kotlinx.android.synthetic.main.activity_onboard_playing.*

class OnboardPlayingActivity : AppCompatActivity() {

    private lateinit var userPref: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard_playing)

        userPref = UserPreferences(this)

        btn_next.setOnClickListener {
            var intent = Intent(this@OnboardPlayingActivity, OnboardPresaleActivity::class.java)
            startActivity(intent)
        }
        btn_skip.setOnClickListener {
            userPref.setValue("is_onboarding_done", "1")

            finishAffinity()

            var intent = Intent(this@OnboardPlayingActivity, SigninActivity::class.java)
            startActivity(intent)
        }
    }
}
