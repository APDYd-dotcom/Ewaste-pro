package bi.clubtechlac.ewaste.ui.app.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import bi.clubtechlac.ewaste.viewmodel.EwasteViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Router(ewasteViewModel: EwasteViewModel = hiltViewModel()) {
    Surface {
        Column{
            val navController = rememberNavController()
          MyNavigation(
            navController,
            ewasteViewModel = ewasteViewModel
          )
        }
    }
}