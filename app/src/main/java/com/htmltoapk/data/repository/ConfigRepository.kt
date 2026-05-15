package com.htmltoapk.data.repository

import com.htmltoapk.data.model.FirebaseConfig
import com.htmltoapk.data.security.SecureConfigManager
import javax.inject.Inject

class ConfigRepository @Inject constructor(
    private val secureConfigManager: SecureConfigManager
) {
    fun getFirebaseConfig(): FirebaseConfig? = secureConfigManager.getFirebaseConfig()
    
    fun saveFirebaseConfig(config: FirebaseConfig) = secureConfigManager.saveFirebaseConfig(config)
    
    fun getSyncKey(): String? = secureConfigManager.getSyncKey()
    
    fun setSyncKey(key: String) = secureConfigManager.setSyncKey(key)
    
    fun clearConfig() = secureConfigManager.clearAll()
    
    fun isConfigured(): Boolean = secureConfigManager.getFirebaseConfig() != null
}