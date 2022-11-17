package ir.kazemcodes.androidprojecttemplate.ui.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import ir.kazemcodes.androidprojecttemplate.ui.components.Toolbar


@Destination
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen() {

    Scaffold(
        topBar = {
            Toolbar(
                title = {
                    Text(text = "Detail")
                }
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Detail Screen")

        }

    }
}