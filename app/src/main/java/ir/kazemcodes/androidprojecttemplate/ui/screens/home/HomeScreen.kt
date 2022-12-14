package ir.kazemcodes.androidprojecttemplate.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import ir.kazemcodes.androidprojecttemplate.ui.components.Toolbar
import ir.kazemcodes.androidprojecttemplate.ui.screens.destinations.DetailScreenDestination


@RootNavGraph(start = true)
@Destination
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {

    Scaffold(
        topBar = {
            Toolbar(
                title = {
                    Text(text = "Home")
                }
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "HomeScreen",modifier = Modifier.clickable {
                navigator.navigate(DetailScreenDestination())
            })

        }

    }
}