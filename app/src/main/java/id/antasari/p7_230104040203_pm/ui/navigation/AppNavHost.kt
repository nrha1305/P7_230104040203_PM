package id.antasari.p7_230104040203_pm.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import id.antasari.p7_230104040203_pm.*
import id.antasari.p7_230104040203_pm.ui.auth.AuthViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    onBiometricAuth: () -> Unit
) {
    val state = authViewModel.uiState.collectAsState().value

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                state = state,
                onEmailChange = authViewModel::onEmailChange,
                onPasswordChange = authViewModel::onPasswordChange,
                onSignInClick = {
                    authViewModel.login { navController.navigate("home") }
                },
                onCreateAccountClick = { navController.navigate("create_account") },
                onBiometricClick = onBiometricAuth
            )
        }
        composable("create_account") {
            CreateAccountScreen(
                onSignUpClick = { name, email, pass ->
                    authViewModel.setAccount(name, email, pass, true, false, true)
                    navController.popBackStack()
                },
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("home") {
            HomeScreen(
                userName = state.name,
                onLogoutClick = {
                    authViewModel.logout()
                    navController.navigate("login") { popUpTo(0) }
                },
                onSettingsClick = { navController.navigate("settings") }
            )
        }
        composable("settings") {
            SettingsScreen(
                state = state,
                onBackClick = { navController.popBackStack() },
                onToggleTheme = authViewModel::toggleTheme,
                onToggleBiometric = authViewModel::toggleBiometric,
                onToggleAppLock = authViewModel::toggleAppLock
            )
        }
    }
}