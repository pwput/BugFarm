package pl.put.bugfarm.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import pl.put.bugfarm.ui.components.BottomBarScreen
import pl.put.bugfarm.ui.farm.FarmScreen
import pl.put.bugfarm.ui.speciments.SpecimentAddScreen
import pl.put.bugfarm.ui.speciments.SpecimentInfoScreen
import pl.put.bugfarm.ui.speciments.SpecimentListScreen
import pl.put.bugfarm.ui.terrariums.TerrariumAddScreen
import pl.put.bugfarm.ui.terrariums.TerrariumListScreen


@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Farm.route
    ) {
        composable(route = BottomBarScreen.Farm.route) {
            FarmScreen()
        }
        composable(route = BottomBarScreen.Spieces.route){
            SpecimentListScreen(
                onInfoClick = {navController.navigate(SpiecesScreen.Information.route)},
                onAddClick = { navController.navigate(SpiecesScreen.Add.route)})
        }
        composable(route = BottomBarScreen.Terraria.route){
           TerrariumListScreen(onAddClick = { navController.navigate(TerrariaScreen.Add.route) })
        }
        spiecesNavGraph(navController)
        terrariaNavGraph(navController)

    }
}

fun NavGraphBuilder.spiecesNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.SPIECES,
        startDestination = SpiecesScreen.List.route
    ) {
        composable(route = SpiecesScreen.List.route) {
            navController.navigate(BottomBarScreen.Spieces.route)
        }
        composable(route = SpiecesScreen.Information.route) {
            SpecimentInfoScreen(onChangeClick =
            { navController.popBackStack(route = SpiecesScreen.List.route, inclusive = false) })
        }
        composable(route = SpiecesScreen.Add.route) {
            SpecimentAddScreen(onAddClick =
                { navController.popBackStack(route = SpiecesScreen.List.route, inclusive = false) })
        }
    }


}

fun NavGraphBuilder.terrariaNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.TERRARIA,
        startDestination = TerrariaScreen.List.route
    ){
        composable(route = TerrariaScreen.List.route){
            navController.navigate(BottomBarScreen.Terraria.route)
        }
        composable(route = TerrariaScreen.Add.route){
            TerrariumAddScreen(onAddClick = {navController.popBackStack(route = TerrariaScreen.List.route, inclusive = false)})
        }
    }
}

sealed class SpiecesScreen(val route: String) {
    object List : SpiecesScreen(route = "SPIECES_LIST")
    object Information : SpiecesScreen(route = "SPIECES_INFORMATION")
    object Add : SpiecesScreen(route = "SPIECES_ADD")
}

sealed class TerrariaScreen(val route: String) {
    object List : TerrariaScreen(route = "TERRARIA_LIST")
    object Add : TerrariaScreen(route = "TERRARIA_ADD")
}