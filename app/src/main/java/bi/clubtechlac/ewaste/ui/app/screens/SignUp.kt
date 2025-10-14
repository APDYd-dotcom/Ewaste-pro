package bi.clubtechlac.ewaste.ui.app.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import bi.clubtechlac.ewaste.ui.app.components.MyPasswordTextField
import bi.clubtechlac.ewaste.ui.app.components.MyTextFieldComponent
import bi.clubtechlac.ewaste.ui.app.components.TextHeadComponent
import bi.clubtechlac.ewaste.ui.app.components.TextNormComponent
import bi.clubtechlac.ewaste.ui.app.components.TextNormComponentLink
import bi.clubtechlac.ewaste.R

val innerpadding = 16.dp
val innerSpace = 8.dp

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SetJavaScriptEnabled") // For WebView settings
@Composable
fun SingUp(
    onLoginClick: () -> Unit,
) {
    val (name, setname) = rememberSaveable { mutableStateOf("") }
    val (phone, setphone) = rememberSaveable { mutableStateOf("") }
    val (password, setPassword) = rememberSaveable { mutableStateOf("") }
    val (confpassword, setconfPassword) = rememberSaveable { mutableStateOf("") }
    val (checked, onCheckedChange) = rememberSaveable { mutableStateOf(false) }
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
            Spacer(modifier = Modifier.height(defaultpadding * 5)) // Already centered by Arrangement.Center


            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "Application Logo",
                modifier = Modifier
                    // .fillMaxWidth() // Image might not need to fill width if it's a logo
                    .size(size = 100.dp) // Adjusted size
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextHeadComponent(value = "Sing Up")
            Spacer(modifier = Modifier.height(20.dp))
            MyTextFieldComponent(
                value = name,
                onValueChange = setname,
                labelText = "Votre Nom",
                leadingIcon = Icons.Default.Call,
                modifier = Modifier.fillMaxWidth(),

                )
            MyTextFieldComponent(
                value = phone,
                onValueChange = setphone,
                labelText = "+257 ...",
                leadingIcon = Icons.Default.Call,
                modifier = Modifier.fillMaxWidth(),

                )
            Spacer(modifier = Modifier.height(innerpadding))
            MyPasswordTextField(
                value = password,
                onValueChange = setPassword,
                labelText = "Mot de passe",
                leadingIcon = Icons.Default.Lock,
                keyboardType = KeyboardType.Password,
                modifier = Modifier.fillMaxWidth(),

                )
            MyPasswordTextField(
                value = confpassword,
                onValueChange = setconfPassword,
                labelText = "Verifier mot de passe",
                leadingIcon = Icons.Default.Lock,
                keyboardType = KeyboardType.Password,
                modifier = Modifier.fillMaxWidth(),

                )


            Spacer(modifier = Modifier.height(innerpadding)) // Add space before checkbox row

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onLoginClick,
                modifier = Modifier.fillMaxWidth(),

                ) {

                TextNormComponent(value = "Envoyer")

            }

            // Pushes the "Sign Up" section to the bottom
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(), // Make row take full width for centering
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    TextNormComponent(value = "Je ai un compte?")
                    TextButton(
                        onClick = onLoginClick,

                        ) { // Corrected callback name
                        TextNormComponentLink(value = "Se Connecter") // Corrected typo
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp)) // Space from bottom edge

        }


    }
}

@Preview(showBackground = true)
@Composable()
fun Previs() {
    SingUp { {} }
}
