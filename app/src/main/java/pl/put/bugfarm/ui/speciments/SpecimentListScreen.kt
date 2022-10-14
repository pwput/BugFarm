package pl.put.bugfarm.ui.speciments

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.put.bugfarm.domain.Speciment

@Composable
fun SpecimentListScreen(
		specimentList: List<Speciment> = listOf<Speciment>()
					   )
{
	Scaffold(
			floatingActionButtonPosition = FabPosition.End,
			floatingActionButton = {
				FloatingActionButton(
						content = { Image(
									painter = painterResource(id = pl.put.bugfarm.R.drawable.ic_baseline_add_24),
									contentDescription = "add_new_speciment_button",
									modifier = Modifier
											.height(24.dp)
											.width(24.dp)
								 ) },
						onClick = { addNewSpeciment() }
											)
			},
			) {
		Column(
				modifier = Modifier
						.fillMaxSize()
						.background(MaterialTheme.colors.surface)
						.wrapContentSize(Alignment.Center)
						.padding(it)

			  ) {
			Text(
					text = "Speciment List View",
					fontWeight = FontWeight.Bold,
					color = MaterialTheme.colors.onSurface,
					modifier = Modifier.align(Alignment.CenterHorizontally),
					textAlign = TextAlign.Center,
					fontSize = 25.sp
				)
		}
	}
}

fun addNewSpeciment(){

}