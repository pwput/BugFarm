package pl.put.bugfarm.ui.terrariums

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
import pl.put.bugfarm.R
import pl.put.bugfarm.domain.Speciment
import pl.put.bugfarm.ui.BottomBar
import pl.put.bugfarm.ui.theme.BugfarmTheme

@Composable
fun TerrariumListScreen(
    onAddClick: () -> Unit,
    terrariumList: List<Speciment> = listOf<Speciment>()
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { onAddClick() }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_add_24),
                    contentDescription = "add_new_speciment_button",
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )
            }
        }) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.surface)
                .wrapContentSize(Alignment.Center)
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement =Arrangement.Center

        ) {

            Text(
                text = "Terrarium List View",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TerrariuListPreview() {
    BugfarmTheme() {
        TerrariumListScreen(onAddClick = { /*TODO*/ })
    }
}


