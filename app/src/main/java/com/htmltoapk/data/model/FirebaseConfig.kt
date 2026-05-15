package com.htmltoapk.data.model

import java.io.Serializable

data class FirebaseConfig(
    val apiKey: String = "",
    val authDomain: String = "",
    val projectId: String = "",
    val storageBucket: String = "",
    val messagingSenderId: String = "",
    val appId: String = "",
    val measurementId: String = "",
    val databaseUrl: String = ""
) : Serializable