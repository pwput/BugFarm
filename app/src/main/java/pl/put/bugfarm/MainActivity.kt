package pl.put.bugfarm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import pl.put.bugfarm.graphs.RootNavigationGrap
import pl.put.bugfarm.ui.theme.BugfarmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BugfarmTheme {
                RootNavigationGrap(navController = rememberNavController())
            }
        }
    }
}


