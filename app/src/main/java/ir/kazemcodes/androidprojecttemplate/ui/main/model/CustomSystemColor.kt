package ir.kazemcodes.androidprojecttemplate.ui.main.model

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

data class CustomSystemColor(
    val status: Color,
    val navigation: Color
)

fun ColorScheme.isLight() = this.surface.luminance() > 0.5