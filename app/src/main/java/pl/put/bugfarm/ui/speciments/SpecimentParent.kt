package pl.put.bugfarm.ui.speciments

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import pl.put.bugfarm.ui.terrariums.TerrariumAdd
import pl.put.bugfarm.ui.terrariums.TerrariumDestinations
import pl.put.bugfarm.ui.terrariums.TerrariumListScreen

object SpecimentDestinations {
	const val LIST = "list"
	const val ADD = "add"
	const val INFO = "info"
}

@Composable
fun SpecimentParent()
{
	val state = remember{ mutableStateOf(SpecimentDestinations.LIST) }
	when(state.value){
		SpecimentDestinations.ADD -> SpecimentAddScreen({state.value = it})
		SpecimentDestinations.INFO -> SpecimentInfoScreen({state.value = it})
		else-> SpecimentListScreen({state.value = it})
	}
}