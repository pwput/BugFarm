package pl.put.bugfarm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import pl.put.bugfarm.ui.components.BugFarmTabsContent
import pl.put.bugfarm.ui.components.TabItem
import pl.put.bugfarm.ui.components.Tabs
import pl.put.bugfarm.ui.login.LoginScreen
import pl.put.bugfarm.ui.theme.BugfarmTheme

class MainActivity : ComponentActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)

		setContent {
			BugFarmApp()
		}
	}
}

@Composable
fun BugFarmApp()
{
	val isLoggedIn = remember {
		mutableStateOf(false)
	}
	if (isLoggedIn.value)
		MainScreen()
	else
		LoginScreen { isLoggedIn.value = true }
}

@Composable
fun TopBar()
{
	TopAppBar(
			title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
			backgroundColor = MaterialTheme.colors.primary,
			contentColor = MaterialTheme.colors.onPrimary
			 )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview()
{
	TopBar()
}

@Composable
fun BugFarm()
{
	BugfarmTheme {
		MainScreen()
	}
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen()
{
	val tabs = listOf(TabItem.Farm, TabItem.Speciment, TabItem.Tarrarium)
	val pagerState = rememberPagerState()
	Scaffold(
			topBar = { TopBar() },
			) { padding ->
		Column(modifier = Modifier.padding(padding)) {
			Tabs(tabs = tabs, pagerState = pagerState)
			BugFarmTabsContent(tabs = tabs, pagerState = pagerState)

		}
	}
}
