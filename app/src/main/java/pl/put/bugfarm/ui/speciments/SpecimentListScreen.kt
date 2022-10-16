package pl.put.bugfarm.ui.speciments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pl.put.bugfarm.domain.Speciment
import pl.put.bugfarm.ui.BottomBar

@Composable
fun SpecimentListScreen(
    onInfoClick: (Speciment) -> Unit,
    onAddClick: () -> Unit,
    specimentList: List<Speciment> = listOf<Speciment>()
) {

    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .wrapContentSize(Alignment.Center)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = "Speciment List View",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
        FloatingActionButton(onClick = { onAddClick() }) {
            Image(
                painter = painterResource(id = pl.put.bugfarm.R.drawable.ic_baseline_add_24),
                contentDescription = "add_new_speciment_button",
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
            )
        }
        Text(
            text = "Speciment List View",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}


fun addNewSpeciment() {

}

@Preview
@Composable
fun ListPreview() {
//	val state = remember{ mutableStateOf(SpecimentDestinations.LIST) }
//	SpecimentListScreen(onStateChange = {state.value = it})
}
