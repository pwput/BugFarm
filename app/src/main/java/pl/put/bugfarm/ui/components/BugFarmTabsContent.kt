package pl.put.bugfarm.ui.components

import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import pl.put.bugfarm.ui.farm.FarmScreen
import pl.put.bugfarm.ui.speciments.SpecimentListScreen
import pl.put.bugfarm.ui.terrariums.TerrariumListScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var title: String, var screen: ComposableFun)
{
	object Farm : TabItem("Farm", { FarmScreen() })
	object Speciment : TabItem("Speciments", { SpecimentListScreen() })
	object Tarrarium : TabItem("Terrrarium", { TerrariumListScreen() })
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BugFarmTabsContent(tabs: List<TabItem>, pagerState: PagerState)
{
	HorizontalPager(state = pagerState, count = tabs.size) { page ->
		tabs[page].screen()
	}
}