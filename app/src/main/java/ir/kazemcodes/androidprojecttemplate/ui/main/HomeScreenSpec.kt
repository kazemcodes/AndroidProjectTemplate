package ir.kazemcodes.androidprojecttemplate.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ir.kazemcodes.androidprojecttemplate.R
import ir.kazemcodes.androidprojecttemplate.ui.components.Toolbar
import ir.kazemcodes.androidprojecttemplate.ui.main.model.Controller
import ir.kazemcodes.androidprojecttemplate.ui.screens.home.HomeScreen

object HomeScreenSpec : ScreenSpec {

    override val navHostRoute: String = "home_screen_route"
    @ExperimentalMaterial3Api
    @Composable
    override fun TopBar(
        controller: Controller
    ) {
        Toolbar(title = {
            Text(text = "Home Screen")
        })
    }


    @Composable
    override fun Content(
        controller: Controller
    ) {
        HomeScreen()
    }

}
