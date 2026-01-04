package id.antasari.p7_230104040203_pm

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.antasari.p7_230104040203_pm.ui.components.AppTextField
import id.antasari.p7_230104040203_pm.ui.components.PrimaryButton

@Composable
fun CreateAccountScreen(
    onSignUpClick: (String, String, String) -> Unit,
    onBackClick: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                IconButton(onClick = onBackClick) { Icon(Icons.Default.ArrowBack, null, tint = MaterialTheme.colorScheme.primary) }
                Text("Create Account", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
            }

            Spacer(Modifier.height(32.dp))
            Text("Join Authix", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.onBackground)

            Spacer(Modifier.height(32.dp))

            AppTextField(name, { name = it }, "Full Name", leadingIcon = Icons.Default.Person)
            Spacer(Modifier.height(16.dp))
            AppTextField(email, { email = it }, "Email Address", leadingIcon = Icons.Default.Email)
            Spacer(Modifier.height(16.dp))
            AppTextField(password, { password = it }, "Password", leadingIcon = Icons.Default.Lock, isPassword = true)

            Spacer(Modifier.height(32.dp))
            PrimaryButton("Sign Up", onClick = { onSignUpClick(name, email, password) })
        }
    }
}