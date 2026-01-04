package id.antasari.p7_230104040203_pm

import android.content.Context
import androidx.biometric.BiometricManager

object BiometricUtils {
    fun isBiometricReady(context: Context): Boolean {
        val manager = BiometricManager.from(context)
        return manager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.BIOMETRIC_WEAK) == BiometricManager.BIOMETRIC_SUCCESS
    }
}