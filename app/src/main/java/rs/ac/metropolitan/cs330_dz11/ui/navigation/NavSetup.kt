package rs.ac.metropolitan.cs330_dz11.ui.navigation

import androidx.compose.runtime.Composable
import rs.ac.metropolitan.cs330_dz11.AppViewModel
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import rs.ac.metropolitan.cs330_dz11.ui.view.HomeScreen
import rs.ac.metropolitan.cs330_dz11.ui.view.NewUserScreen
import rs.ac.metropolitan.cs330_dz11.ui.view.UserDetailScreen


@Composable
fun NavSetup() {
    val navController = rememberNavController()
    val vm: AppViewModel = viewModel()
    val paddingValues = PaddingValues()
    vm.navController = navController

    NavHost(navController = navController, startDestination = NavigationRoutes.Home.route) {
        composable(route = NavigationRoutes.Home.route) {
            HomeScreen(
                userList = vm.userz,
                loadUser = vm::loadUserz,
                goToNewUser = { navController.goToNewUser() },
                goToDetails = { navController.goToDetails(it) }
            )
        }
        composable(route = NavigationRoutes.UserDetailScreen.route) { navBackStackEntry ->
            val elementId = navBackStackEntry.arguments?.getString("elementId")
            if (elementId != null) {
                UserDetailScreen(
                    userItem = vm.getUser(elementId),
                    goBack = { navController.goBack() },
                    deleteUser = { vm.deleteUser(elementId) },
                )
            } else {
                Toast.makeText(
                    navController.context,
                    "Error, elementId is required!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        composable(route = NavigationRoutes.NewUser.route) {
            NewUserScreen(
                submitUser = vm::submitUser,
                goBack = { navController.goBack() }
            )
        }
    }
}

fun NavController.goBack() {
    this.popBackStack()
}

fun NavController.goToNewUser() {
    this.navigate(NavigationRoutes.NewUser.route)
}

fun NavController.goToDetails(id: String) {
    this.navigate(NavigationRoutes.UserDetailScreen.createRoute(id))
}