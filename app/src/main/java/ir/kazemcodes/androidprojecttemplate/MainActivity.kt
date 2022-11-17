package ir.kazemcodes.androidprojecttemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.ramcosta.composedestinations.DestinationsNavHost
import ir.kazemcodes.androidprojecttemplate.ui.screens.NavGraphs
import ir.kazemcodes.androidprojecttemplate.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.onSurface,
                ) {
                    //ScreenContent()
                    DestinationsNavHost(navGraph = NavGraphs.root)
                }
            }
        }
    }
}


fun setupNavigation() {

}