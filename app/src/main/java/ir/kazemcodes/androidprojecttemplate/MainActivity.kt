package ir.kazemcodes.androidprojecttemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import ir.kazemcodes.androidprojecttemplate.ui.screens.ScreenContent
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
                    ScreenContent()
                }
            }
        }
    }
}
