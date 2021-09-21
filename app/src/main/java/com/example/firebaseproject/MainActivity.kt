package com.example.firebaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.firebaseproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val remoteConfig = RemoteConfig()
        remoteConfig.initialize(this)

        if(remoteConfig.getBoolean("login_button_enabled")) {
            binding.button.visibility = View.VISIBLE
        }



        binding.button.setOnClickListener {
            Analytics.logEvent(Analytics.Event("LOGIN", listOf(Pair("button_click", "login"))))
        }
    }
}