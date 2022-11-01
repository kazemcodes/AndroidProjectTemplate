package ir.kazemcodes.androidprojecttemplate.ui.theme

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

interface ThemeRepository {

    fun subscribe(): Flow<List<Theme>>
}

class ThemeRepositoryImpl(

) : ThemeRepository {
    override fun subscribe(): Flow<List<Theme>> {
        return emptyFlow()
    }
}