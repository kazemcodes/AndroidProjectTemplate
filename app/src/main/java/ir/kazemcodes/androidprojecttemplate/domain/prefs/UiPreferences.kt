package ir.kazemcodes.androidprojecttemplate.domain.prefs

import ir.kazemcodes.androidprojecttemplate.domain.core.prefs.Preference
import ir.kazemcodes.androidprojecttemplate.domain.core.prefs.PreferenceStore
import ir.kazemcodes.androidprojecttemplate.domain.core.prefs.getEnum
import org.koin.core.annotation.Single

@Single
class UiPreferences(private val preferenceStore: PreferenceStore) {
    fun themeMode(): Preference<PreferenceValues.ThemeMode> {
        return preferenceStore.getEnum("theme_mode", PreferenceValues.ThemeMode.System)
    }

    fun colorTheme(): Preference<Long> {
        return preferenceStore.getLong("color_theme", -1L)
    }


    fun colorPrimaryLight(): Preference<Int> {
        return preferenceStore.getInt("color_primary_light", 0)
    }

    fun colorPrimaryDark(): Preference<Int> {
        return preferenceStore.getInt("color_primary_dark", 0)
    }

    fun colorSecondaryLight(): Preference<Int> {
        return preferenceStore.getInt("color_secondary_light", 0)
    }

    fun colorSecondaryDark(): Preference<Int> {
        return preferenceStore.getInt("color_secondary_dark", 0)
    }

    fun colorBarsLight(): Preference<Int> {
        return preferenceStore.getInt("color_bar_light", 0)
    }

    fun colorBarsDark(): Preference<Int> {
        return preferenceStore.getInt("color_bar_dark", 0)
    }


    fun confirmExit(): Preference<Boolean> {
        return preferenceStore.getBoolean("confirm_exit", false)
    }
}
