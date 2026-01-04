package id.antasari.p7_230104040203_pm

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import id.antasari.p7_230104040203_pm.ui.auth.AuthViewModel
import id.antasari.p7_230104040203_pm.ui.navigation.AppNavHost
import id.antasari.p7_230104040203_pm.ui.theme.P7ModernUiTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect

class MainActivity : FragmentActivity() {

    // Deklarasi ViewModel di level Activity
    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inisialisasi ViewModel DI LUAR setContent
        viewModel = ViewModelProvider(this)[AuthViewModel::class.java]

        // 2. Load data dan cek Biometric HANYA SEKALI di sini
        val biometricAvailable = BiometricUtils.isBiometricReady(this)
        viewModel.setBiometricAvailability(biometricAvailable)

        val stored = AccountStorage.loadAccount(this)
        if (stored != null) {
            viewModel.setAccount(
                stored.name,
                stored.email,
                stored.password,
                stored.biometricEnabled,
                stored.isDarkTheme,
                stored.appLockEnabled
            )
        }

        setContent {
            // Ambil state terbaru dari ViewModel
            val state by viewModel.uiState.collectAsState()
            val navController = rememberNavController()

            // 3. Simpan data otomatis (Auto-Save) menggunakan LaunchedEffect
            // Ini hanya akan jalan jika 'state' berubah, bukan looping terus menerus
            LaunchedEffect(state) {
                if (state.registeredEmail != null) {
                    AccountStorage.saveAccount(
                        this@MainActivity,
                        StoredAccount(
                            state.name,
                            state.registeredEmail!!,
                            state.registeredPassword!!,
                            state.isBiometricEnabled,
                            state.isDarkTheme,
                            state.isAppLockEnabled
                        )
                    )
                }
            }

            // Terapkan tema sesuai state
            P7ModernUiTheme(darkTheme = state.isDarkTheme) {
                AppNavHost(
                    navController = navController,
                    authViewModel = viewModel,
                    onBiometricAuth = {
                        showBiometricPrompt(viewModel) {
                            navController.navigate("home")
                        }
                    }
                )
            }
        }
    }

    private fun showBiometricPrompt(viewModel: AuthViewModel, onSuccess: () -> Unit) {
        val executor = ContextCompat.getMainExecutor(this)
        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Authix Secure Login")
            .setSubtitle("Touch the sensor!")
            .setNegativeButtonText("Cancel")
            .build()

        val biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    viewModel.loginBiometric(onSuccess)
                    Toast.makeText(applicationContext, "Welcome back!", Toast.LENGTH_SHORT).show()
                }
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(applicationContext, "Auth error: $errString", Toast.LENGTH_SHORT).show()
                }
            })

        biometricPrompt.authenticate(promptInfo)
    }
}