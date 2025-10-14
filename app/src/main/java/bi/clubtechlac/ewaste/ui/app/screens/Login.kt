package bi.clubtechlac.ewaste.ui.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import bi.clubtechlac.ewaste.ui.app.components.MyTextFieldComponent
import bi.clubtechlac.ewaste.ui.app.components.MyPasswordTextField
import bi.clubtechlac.ewaste.R
import bi.clubtechlac.ewaste.ui.app.components.TextHeadComponent
import bi.clubtechlac.ewaste.ui.app.components.TextNormComponent
import bi.clubtechlac.ewaste.ui.app.components.TextNormComponentLink

val defaultpadding = 16.dp
val innerrpadding = 8.dp // Added definition for innerpadding


@Composable
fun Login(onLoginSuccess: () -> Unit, onSignUp: () -> Unit) { // Renamed onSingUp to onSignUp

    val (email, setEmail) = rememberSaveable { mutableStateOf("") }
    val (password, setPassword) = rememberSaveable { mutableStateOf("") }
    val (checked, onCheckedChange) = rememberSaveable { mutableStateOf(false) }

    val (isLoading, setIsLoading) = rememberSaveable { mutableStateOf(false) }
    val (apiError, setApiError) = rememberSaveable { mutableStateOf<String?>(null) }



    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        color = MaterialTheme.colorScheme.background
    ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = defaultpadding),
//                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally // Center content like Image
            ) {
                Spacer(modifier = Modifier.height(defaultpadding*5)) // Already centered by Arrangement.Center

               

                Image(
                    painter = painterResource(id = R.drawable.app_logo),
                    contentDescription = "Application Logo",
                    modifier = Modifier
                        // .fillMaxWidth() // Image might not need to fill width if it's a logo
                        .size(size = 100.dp) // Adjusted size
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextHeadComponent(value = "Login")
                Spacer(modifier = Modifier.height(20.dp))
                MyTextFieldComponent(
                    value = email,
                    onValueChange = setEmail,
                    labelText = "+257 ...",
                    leadingIcon = Icons.Default.Call,
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !isLoading
                )
                Spacer(modifier = Modifier.Companion.height(innerpadding))
                MyPasswordTextField(
                    value = password,
                    onValueChange = setPassword,
                    labelText = "Password",
                    leadingIcon = Icons.Default.Lock,
                    keyboardType = KeyboardType.Password,
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !isLoading
                )

                apiError?.let {
                    Spacer(modifier = Modifier.Companion.height(innerpadding))
                    Text(
                        text = it,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.fillMaxWidth().padding(horizontal = innerpadding)
                    )
                }
                Spacer(modifier = Modifier.Companion.height(innerpadding)) // Add space before checkbox row

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(checked, onCheckedChange = onCheckedChange, enabled = !isLoading)
                        TextNormComponent(value = "Remember me")
                    }
                    TextButton(onClick = { /* TODO: Implement Forgot Password */ }, enabled = !isLoading) {
                        TextNormComponentLink(value = "Forgot Password?") // Added question mark
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                   // onClick = { performLogin() },
                    onClick = onLoginSuccess,
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !isLoading
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(24.dp),
                            color = MaterialTheme.colorScheme.onPrimary // Good contrast
                        )
                    } else {
                        TextNormComponent(value = "Login")
                    }
                }

                // Pushes the "Sign Up" section to the bottom
                Column(modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(), // Make row take full width for centering
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        TextNormComponent(value = "Je n'ai pas de compte")
                        TextButton(
                            onClick = onSignUp,
                            enabled = !isLoading
                        ) { // Corrected callback name
                            TextNormComponentLink(value = "Inscrivez-vous") // Corrected typo
                        }
                    }
                }
                    Spacer(modifier = Modifier.height(30.dp)) // Space from bottom edge

            }

    }
}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
fun LoginScreenPreview() { // Renamed preview function for clarity
    MaterialTheme {
        Login(onLoginSuccess = {}, onSignUp = {}) // Corrected onSignUp
    }
}