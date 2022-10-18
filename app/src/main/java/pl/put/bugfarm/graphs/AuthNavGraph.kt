package pl.put.bugfarm.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import pl.put.bugfarm.ui.login.LoginScreen
import pl.put.bugfarm.ui.login.SignUpScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.LogIn.route
    ) {
        composable(route = AuthScreen.LogIn.route) {
            LoginScreen(
                onLogInClick = { logIn(navController) },
                onSignUpClick = { singUp(navController) })
        }
        composable(route = AuthScreen.SignUp.route) {
            SignUpScreen(onSignUpClick = { logIn(navController)})
        }
    }
}

sealed class AuthScreen(val route: String) {
    object LogIn : AuthScreen(route = "LOGIN")
    object SignUp : AuthScreen(route = "SIGN_UP")
}

fun logIn(navController: NavHostController) {
    navController.popBackStack()
    navController.navigate(Graph.HOME)
}

fun singUp(navController: NavHostController) {
    navController.navigate(AuthScreen.SignUp.route)
}