package pl.put.bugfarm.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState)
{
	val scope = rememberCoroutineScope()
	TabRow(
			selectedTabIndex = pagerState.currentPage,
			backgroundColor = MaterialTheme.colors.primary,
			contentColor = MaterialTheme.colors.onPrimary,
			indicator = { tabPositions ->
				TabRowDefaults.Indicator(Modifier.pagerTabIndicatorOffset(pagerState, tabPositions))
			}) {
		tabs.forEachIndexed { index, tab ->
			Tab(
					text = { Text(tab.title) },
					selected = pagerState.currentPage == index,
					onClick = {
						scope.launch {
							pagerState.animateScrollToPage(index)
						}
					}
			   )
		}
	}
}

