package id.antasari.p7_230104040203_pm

import android.content.Context

data class StoredAccount(
    val name: String,
    val email: String,
    val password: String,
    val biometricEnabled: Boolean,
    val isDarkTheme: Boolean,
    val appLockEnabled: Boolean
)

object AccountStorage {
    private const val PREF_NAME = "secure_auth_girly_prefs"
    private const val KEY_NAME = "user_name"
    private const val KEY_EMAIL = "user_email"
    private const val KEY_PASSWORD = "user_password"
    private const val KEY_BIOMETRIC = "biometric_enabled"
    private const val KEY_DARK_THEME = "dark_theme"
    private const val KEY_APP_LOCK = "app_lock_enabled"

    fun saveAccount(context: Context, account: StoredAccount) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        prefs.edit().apply {
            putString(KEY_NAME, account.name)
            putString(KEY_EMAIL, account.email)
            putString(KEY_PASSWORD, account.password)
            putBoolean(KEY_BIOMETRIC, account.biometricEnabled)
            putBoolean(KEY_DARK_THEME, account.isDarkTheme)
            putBoolean(KEY_APP_LOCK, account.appLockEnabled)
            apply()
        }
    }

    fun loadAccount(context: Context): StoredAccount? {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val email = prefs.getString(KEY_EMAIL, null) ?: return null
        return StoredAccount(
            name = prefs.getString(KEY_NAME, "") ?: "",
            email = email,
            password = prefs.getString(KEY_PASSWORD, "") ?: "",
            biometricEnabled = prefs.getBoolean(KEY_BIOMETRIC, false),
            isDarkTheme = prefs.getBoolean(KEY_DARK_THEME, false),
            appLockEnabled = prefs.getBoolean(KEY_APP_LOCK, true)
        )
    }

    fun clearAccount(context: Context) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit().clear().apply()
    }
}