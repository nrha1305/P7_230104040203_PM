package id.antasari.p7_230104040203_pm.ui.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class AuthUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val isSignedIn: Boolean = false,
    val isBiometricAvailable: Boolean = false,
    val isBiometricEnabled: Boolean = false,
    val isDarkTheme: Boolean = false,
    val isAppLockEnabled: Boolean = true,
    val registeredEmail: String? = null,
    val registeredPassword: String? = null,
    val error: String? = null
)

class AuthViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState = _uiState.asStateFlow()

    fun onNameChange(v: String) { _uiState.value = _uiState.value.copy(name = v) }
    fun onEmailChange(v: String) { _uiState.value = _uiState.value.copy(email = v) }
    fun onPasswordChange(v: String) { _uiState.value = _uiState.value.copy(password = v) }

    fun setBiometricAvailability(available: Boolean) {
        _uiState.value = _uiState.value.copy(isBiometricAvailable = available)
    }

    fun setAccount(name: String, email: String, pass: String, bioEnabled: Boolean, darkTheme: Boolean, appLock: Boolean) {
        _uiState.value = _uiState.value.copy(
            name = name,
            registeredEmail = email,
            registeredPassword = pass,
            isBiometricEnabled = bioEnabled,
            isDarkTheme = darkTheme,
            isAppLockEnabled = appLock
        )
    }

    fun login(onSuccess: () -> Unit) {
        val s = _uiState.value
        if (s.email == s.registeredEmail && s.password == s.registeredPassword) {
            _uiState.value = s.copy(isSignedIn = true, error = null)
            onSuccess()
        } else {
            _uiState.value = s.copy(error = "Email atau password salah!")
        }
    }

    fun loginBiometric(onSuccess: () -> Unit) {
        _uiState.value = _uiState.value.copy(isSignedIn = true, error = null)
        onSuccess()
    }

    fun logout() {
        _uiState.value = _uiState.value.copy(isSignedIn = false, email = "", password = "")
    }

    fun toggleTheme(isDark: Boolean) {
        _uiState.value = _uiState.value.copy(isDarkTheme = isDark)
    }

    fun toggleBiometric(enabled: Boolean) {
        _uiState.value = _uiState.value.copy(isBiometricEnabled = enabled)
    }

    fun toggleAppLock(enabled: Boolean) {
        _uiState.value = _uiState.value.copy(isAppLockEnabled = enabled)
    }
}