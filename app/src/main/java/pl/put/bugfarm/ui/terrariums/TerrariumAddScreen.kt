package pl.put.bugfarm.ui.terrariums

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pl.put.bugfarm.ui.BottomBar
import pl.put.bugfarm.ui.speciments.SpecimentInfoScreen
import pl.put.bugfarm.ui.theme.BugfarmTheme

@Composable
fun TerrariumAddScreen(
	onAddClick: () -> Unit
					  ){
	Scaffold{
	Column(
			modifier = Modifier
				.background(MaterialTheme.colors.surface)
				.wrapContentSize(Alignment.Center)
				.padding(it)

		  ) {
		Text(
				text = "Add Terrarium",
				fontWeight = FontWeight.Bold,
				color = MaterialTheme.colors.onSurface,
				modifier = Modifier.align(Alignment.CenterHorizontally),
				textAlign = TextAlign.Center,
				fontSize = 25.sp
			)
		TextButton(onClick = { onAddClick() }) { Text(text = "add terrarium") }
	}
}
}

@Preview(showSystemUi = true)
@Composable
fun TerrariumAddScreenPreview(){
	BugfarmTheme() {
		TerrariumAddScreen {
		}
	}
}