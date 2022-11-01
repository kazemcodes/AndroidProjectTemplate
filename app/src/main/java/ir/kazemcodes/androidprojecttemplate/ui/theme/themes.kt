package ir.kazemcodes.androidprojecttemplate.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import ir.kazemcodes.androidprojecttemplate.ui.main.model.ExtraColors


val themes = listOf<Theme>(
    Theme(
        id = -3, materialColors = lightColorScheme(
            primary = Colour.blue_accent,
            primaryContainer = Colour.blue_700,
            onPrimary = Colour.white_50,
            secondary = Colour.blue_accent,
            onSecondary = Colour.white_50,
            background = Colour.white_50,
            surface = Colour.white_50,
            onBackground = Colour.black_900,
            onSurface = Colour.black_900,
            error = Colour.red_600,
            onError = Colour.white_50,
        ), extraColors = ExtraColors(
            bars = Color.White,
            onBars = Color.Black
        ), isDark = false
    ),
   Theme(
        id = -4, materialColors = darkColorScheme(
            primary = Colour.blue_accent,
            primaryContainer = Colour.blue_600,
            onPrimary = Colour.black_900,
            secondary = Colour.blue_accent,
            onSecondary = Colour.black_900,
            background = Color(0xFF121212),
            surface = Color(0xFF000000),
            onBackground = Colour.white_50,
            onSurface = Colour.white_50,
            error = Colour.red_600,
            onError = Colour.black_900,
        ), extraColors = ExtraColors(
            bars = Color(0xFF181818),
            onBars = Color.White
        ), isDark = true
    ),
).toMutableList()


data class Theme(
    val id: Long,
    val materialColors: ColorScheme,
    val extraColors: ExtraColors,
    val isDark: Boolean = false,
)
