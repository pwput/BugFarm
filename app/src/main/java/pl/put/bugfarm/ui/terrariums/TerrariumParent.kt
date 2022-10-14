package pl.put.bugfarm.ui.terrariums

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun TerrariumParent()
{
	val state = remember{ mutableStateOf(TerrariumDestinations.LIST)}
	if (state.value == TerrariumDestinations.LIST)
		TerrariumListScreen({ state.value = it })
	else
		TerrariumAdd({ state.value = it })
}
object TerrariumDestinations {
	const val LIST = "list"
	const val ADD = "add"
}

