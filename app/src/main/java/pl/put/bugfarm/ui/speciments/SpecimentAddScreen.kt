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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.put.bugfarm.domain.Speciment
import pl.put.bugfarm.ui.theme.BugfarmTheme

@Composable
fun SpecimentAddScreen(
    onAddClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
            .wrapContentSize(Alignment.Center)
            .padding(16.dp)

    ) {
        Text(
            text = "Speciment Add View",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onSurface,
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
        TextButton(onClick = { onAddClick() }) { Text(text = "add speciment") }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SpecimentAddScreenPreview(){
    BugfarmTheme() {
        SpecimentAddScreen {
        }
    }
}
