package ir.kazemcodes.androidprojecttemplate.ui.screens

import ir.kazemcodes.androidprojecttemplate.domain.core.ui.BaseViewModel
import ir.kazemcodes.androidprojecttemplate.domain.prefs.UiPreferences
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ScreenContentViewModel(
    private val uiPreferences: UiPreferences,
) : BaseViewModel() {
    var confirmExit = uiPreferences.confirmExit().asState()
}