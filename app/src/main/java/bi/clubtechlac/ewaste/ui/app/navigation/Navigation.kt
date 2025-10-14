package bi.clubtechlac.ewaste.ui.app.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import bi.clubtechlac.ewaste.ui.app.screens.Home
import bi.clubtechlac.ewaste.ui.app.screens.Login
import bi.clubtechlac.ewaste.ui.app.screens.SingUp
import bi.clubtechlac.ewaste.ui.app.screens.Submit
import bi.clubtechlac.ewaste.ui.app.page.Descr
import bi.clubtechlac.ewaste.viewmodel.EwasteViewModel

sealed class Route{
    data class Login(val name: String= "Login"):Route()
    data class SingUp(val name: String="SingUp"):Route()
    data class Home(val name: String= "Home"):Route()
    data class Submit(val name: String= "Submit"):Route()
    data class track(val name: String="track"): Route()
    data class Descr(val name: String="descr/{ewasteId}"): Route()
    data class Profile(val name: String="Profile"): Route()
}



@Composable
fun MyNavigation(navHostController: NavHostController, ewasteViewModel: EwasteViewModel) {
    LaunchedEffect(Unit) {
        ewasteViewModel.loadEwaste()
    }
    NavHost(
        navController = navHostController,
        startDestination = Route.Login().name
    ){
        composable(route = Route.Login().name){
            Login(
                onLoginSuccess = {
                    navHostController.navigate(
                        Route.Home().name
                    )
                },
                onSignUp = {
                    navHostController.navigate(
                        Route.SingUp().name
                    )
                },
            )

        }
        composable(route = Route.SingUp().name){
            SingUp(
                onLoginClick = {
                navHostController.navigate(
                    Route.Login().name
                )
               }
            )
        }
        composable(route = Route.Home().name){backStack->
            Home(
                navController = navHostController,
                onSubmitClick = {
                    navHostController.navigate(Route.Submit().name
                    )

                },
                ewasteViewModel = ewasteViewModel,
                exit = {
                    navHostController.navigate(
                        Route.Login().name
                    )
                }
            )


        }
        composable(route = Route.Submit().name){
            Submit(
                onHomeClick = {
                    navHostController.navigate(
                        Route.Home().name
                    )
                },
                exit = {
                    navHostController.navigate(
                        Route.Login().name
                    )
                }
            )
        }
        composable(route = Route.track().name) {

        }
        composable(route = Route.Descr().name) {backStack->
            val ewasteId = backStack.arguments?.getString("ewasteId")?.toInt()
            val ewaste = ewasteViewModel.ewastes.find { it.id == ewasteId }
            Descr(
                onHomeClick = {
                    navHostController.navigate(Route.Home().name)
                },
                ewaste = ewaste,
                navController = navHostController,
                ewasteViewModel = ewasteViewModel
            )
        }
        composable(route = Route.Profile().name) {

        }
    }
}
