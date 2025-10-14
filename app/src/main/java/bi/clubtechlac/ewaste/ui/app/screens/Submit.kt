package bi.clubtechlac.ewaste.ui.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import bi.clubtechlac.ewaste.ui.app.components.MyTextFieldComponent
import bi.clubtechlac.ewaste.ui.app.components.TextHeadComponent
import bi.clubtechlac.ewaste.ui.app.components.TextNormComponent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Submit(onHomeClick:() -> Unit, exit:() -> Unit) {
    val (fullName, setFullName) = rememberSaveable { mutableStateOf("") }
    val (email, setEmail) = rememberSaveable { mutableStateOf("") }
    val (phone, setPhone) = rememberSaveable { mutableStateOf("") }
    val (country, setCountry) = rememberSaveable { mutableStateOf("") }
    val (provence, setProvence) = rememberSaveable { mutableStateOf("") }
    val (commune, setCommune) = rememberSaveable { mutableStateOf("") }
    val (photo, setPhoto) = rememberSaveable { mutableStateOf("") }
    val (weight, setWeight) = rememberSaveable { mutableStateOf("") }
    val (isLoading, setIsLoading) = rememberSaveable { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor =  MaterialTheme.colorScheme.background),
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                            IconButton(onClick = onHomeClick) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "App Logo",
                                    modifier = Modifier.size(size = 32.dp)
                                )
                        }
                        TextHeadComponent(value = "Submit your E-waste")

                    }
                }
            )
        },
        modifier = Modifier.fillMaxWidth()
    ){ innerpadding ->
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(innerpadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(16.dp))
            MyTextFieldComponent(
                modifier = Modifier.fillMaxWidth(),
                value = fullName,
                onValueChange = setFullName,
                labelText = "Full Name",
                leadingIcon = Icons.Default.Person,
                enabled = !isLoading,
            )
            MyTextFieldComponent(
                modifier = Modifier.fillMaxWidth(),
                value = phone,
                onValueChange = setPhone,
                labelText = "Phone Number",
                leadingIcon = Icons.Default.Call,
                enabled = !isLoading,
            )
            MyTextFieldComponent(
                modifier = Modifier.fillMaxWidth(),
                value = country,
                onValueChange = setCountry,
                labelText = "Country",
                leadingIcon = Icons.Default.DateRange,
                enabled = !isLoading,
            )
            MyTextFieldComponent(
                modifier = Modifier.fillMaxWidth(),
                value = provence,
                onValueChange = setProvence,
                labelText = "Province",
                leadingIcon = Icons.Default.KeyboardArrowDown,
                enabled = !isLoading,
            )
            MyTextFieldComponent(
                modifier = Modifier.fillMaxWidth(),
                value = commune,
                onValueChange = setCommune,
                labelText = "Commune",
                leadingIcon = Icons.Default.KeyboardArrowDown,
                enabled = !isLoading,
            )
            MyTextFieldComponent(
                modifier = Modifier.fillMaxWidth(),
                value = photo,
                onValueChange = setPhoto,
                labelText = "Photo",
                leadingIcon = Icons.Default.Home,
                enabled = !isLoading,
            )
            MyTextFieldComponent(
                modifier = Modifier.fillMaxWidth(),
                value = weight,
                onValueChange = setWeight,
                labelText = "Weight Kg",
                leadingIcon = Icons.Default.Menu,
                enabled = !isLoading,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onHomeClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextNormComponent(value = "Envoyer ")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun pv() {
    Submit({},{})
}