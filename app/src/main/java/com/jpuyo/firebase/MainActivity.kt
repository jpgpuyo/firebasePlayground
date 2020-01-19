package com.jpuyo.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOGIN = "login"
        const val LOGOUT = "logout"
        const val USERNAME = "username"
    }

    lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        btnSetUserProperty.setOnClickListener {
            val value = txtUserProperty.text.toString()
            firebaseAnalytics.logEvent(LOGIN, bundleOf(USERNAME to value))
            firebaseAnalytics.setUserProperty(USERNAME, txtUserProperty.text.toString())
        }

        btnCleanUserProperty.setOnClickListener {
            val value = txtUserProperty.text.toString()
            firebaseAnalytics.logEvent(LOGOUT, bundleOf(USERNAME to value))
            firebaseAnalytics.setUserProperty(USERNAME, null)
        }
    }
}
