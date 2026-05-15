package com.htmltoapk.data.local

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.google.gson.Gson
import com.htmltoapk.data.model.FirebaseConfig

class SecureConfigManager(context: Context) {
    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val encryptedPrefs = EncryptedSharedPreferences.create(
        context,
        PREFS_NAME,
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    private val gson = Gson()

    fun saveFirebaseConfig(config: FirebaseConfig) {
        encryptedPrefs.edit().apply {
            putString(KEY_FIREBASE_CONFIG, gson.toJson(config))
            apply()
        }
    }

    fun getFirebaseConfig(): FirebaseConfig? {
        val json = encryptedPrefs.getString(KEY_FIREBASE_CONFIG, null)
        return if (json != null) gson.fromJson(json, FirebaseConfig::class.java) else null
    }

    fun saveSyncKey(key: String) {
        encryptedPrefs.edit().apply {
            putString(KEY_SYNC_KEY, key)
            apply()
        }
    }

    fun getSyncKey(): String? {
        return encryptedPrefs.getString(KEY_SYNC_KEY, null)
    }

    fun clearAll() {
        encryptedPrefs.edit().clear().apply()
    }

    companion object {
        private const val PREFS_NAME = "secure_config_prefs"
        private const val KEY_FIREBASE_CONFIG = "firebase_config"
        private const val KEY_SYNC_KEY = "sync_key"
    }
}