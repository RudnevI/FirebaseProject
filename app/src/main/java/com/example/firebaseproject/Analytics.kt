package com.example.firebaseproject

import android.os.Bundle


import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

object Analytics {

    private const val EVENT_MESSAGE = "eventMessage"

    private const val GENDER = "gender"

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    fun init() {
        firebaseAnalytics = Firebase.analytics
    }

    fun logEvent(event: Event) {

        val bundle = Bundle()
        event.list.forEach {
            bundle.putString(it.first, it.second)
        }
        firebaseAnalytics.logEvent(event.eventName, bundle)
    }

    class Event(
        val eventName: String,
        val list: List<Pair<String, String>>
    )

    fun setGender(gender: Gender) {
        firebaseAnalytics.setUserProperty(GENDER, gender.name)
    }

    enum class Gender {
        MALE,
        FEMALE
    }


}