package pl.put.bugfarm.ui.components

sealed class BottomBarScreen(
    val route: String,
    val title: String,
){
    object Farm:BottomBarScreen(
        route = "FARM",
        title = "FARM"
    )

    object Spieces: BottomBarScreen(
        route = "SPECIES_LIST",
        title = "SPECIES"
    )

    object Terraria: BottomBarScreen(
        route = "TERRARIUM_LIST",
        title = "TERRARIUM"
    )
}