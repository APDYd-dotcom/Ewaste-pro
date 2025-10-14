package bi.clubtechlac.ewaste.ui.app.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import bi.clubtechlac.ewaste.R


/*A Simple OutlinedTextField*/
@Composable
fun MyTextFieldComponent(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    labelText: String,
    leadingIcon: ImageVector? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    enabled: Boolean = true // Good practice to give it a default value
){
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = labelText) },
        leadingIcon = {
            if (leadingIcon != null) {
                Icon(imageVector = leadingIcon, contentDescription = null)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = visualTransformation,
        shape = RoundedCornerShape(percent = 30),
        singleLine = true,
        enabled = enabled
    )
}

/*A Password OutlinedTextField*/
@Composable
fun MyPasswordTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    labelText: String,
    leadingIcon: ImageVector? = null,
    // It's good practice for a password field to default to KeyboardType.Password
    keyboardType: KeyboardType = KeyboardType.Password,
    // Add the enabled parameter
    enabled: Boolean = true
) {
    // Use rememberSaveable for passwordVisible to survive configuration changes like screen rotation
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = labelText) },
        leadingIcon = {
            if (leadingIcon != null) {
                Icon(imageVector = leadingIcon, contentDescription = null)
            }
        },
        trailingIcon = {
            val iconResource = if (passwordVisible) {
                // Assuming R.drawable.visible is your "eye open" icon
                painterResource(id = R.drawable.visible)
            } else {
                // Assuming R.drawable.visibiltyof is your "eye closed" icon
                painterResource(id = R.drawable.visibiltyof)
            }
            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(painter = iconResource, contentDescription = description)
            }
        },
        // Apply the enabled state
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        // Standard visual transformation for password visibility toggle
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        shape = RoundedCornerShape(percent = 30),
        singleLine = true
    )
}



@Preview(showBackground = true)
@Composable
fun MyPasswordTextField(){
    val isLoading = false
    MyTextFieldComponent(
        value = "",
        onValueChange = {},
        labelText = "Password",
        enabled = !isLoading,
    )
}

