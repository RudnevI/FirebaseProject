package com.example.firebaseproject

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings

class RemoteConfig {


    private lateinit var remoteConfig: FirebaseRemoteConfig

    private val configs = FirebaseRemoteConfigSettings.Builder()
        .setMinimumFetchIntervalInSeconds(100)
        .build()

    fun initialize(context: Context) {
        remoteConfig = FirebaseRemoteConfig.getInstance()
        remoteConfig.setConfigSettingsAsync(configs)
        remoteConfig.setDefaultsAsync(R.xml.config_defaults)
        remoteConfig.fetchAndActivate()
            .addOnCompleteListener(context as Activity
            ) { task ->
                if (task.isSuccessful) {
                    println("RemoteConfig fetch successful")
                } else {
                    Log.e("RemoteConfig", "Failed to fetch")
                }
            }
    }
}