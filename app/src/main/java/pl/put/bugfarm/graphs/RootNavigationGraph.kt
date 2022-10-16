package pl.put.bugfarm.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pl.put.bugfarm.ui.HomeScreen
import pl.put.bugfarm.ui.components.BottomBarScreen
import pl.put.bugfarm.ui.farm.FarmScreen

@Composable
fun RootNavigationGrap(navController: NavHostController) {
    NavHost(
        navController = navController, route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navController=navController)
        composable(route = Graph.HOME){
            HomeScreen()
        }
    }
}


object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "farm_graph"
    const val SPIECES= "spieces_graph"
    const val TERRARIA = "terraria_graph"
}