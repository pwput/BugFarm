package pl.put.bugfarm.ui.terrariums

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TerrariumAdd(		onStateChange: (String) -> Unit
					  ){
	Scaffold{
	Column(
			modifier = Modifier
					.fillMaxSize()
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
	}
}
}

		fun addTerrarium(){

		}