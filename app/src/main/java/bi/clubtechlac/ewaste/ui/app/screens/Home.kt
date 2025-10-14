package bi.clubtechlac.ewaste.ui.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import bi.clubtechlac.ewaste.ui.app.components.EwasteCard
import bi.clubtechlac.ewaste.R
import bi.clubtechlac.ewaste.viewmodel.EwasteViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(onSubmitClick: () -> Unit,navController: NavController, exit: () -> Unit, ewasteViewModel: EwasteViewModel ) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background ),
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.app_logo ),
                            contentDescription = "App Logo",
                            modifier = Modifier.size(size = 40.dp)
                        )
                        IconButton(onClick = exit) {
                            Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "menu")
                        }

                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onSubmitClick) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) { innerpadding ->
        val ewastes = ewasteViewModel.ewastes
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(innerpadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {items(ewastes){ewaste->
                Spacer(modifier = Modifier.height(height = 8.dp))
                EwasteCard(
                    ewaste = ewaste,
                    navController = navController
                )
                Spacer(modifier = Modifier.height(height = 8.dp))
            }

        }
    }
}


//@Preview
//@Composable
//fun pvHome(){
//    Home({},{})
//}