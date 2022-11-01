package ir.kazemcodes.androidprojecttemplate.di

import ir.kazemcodes.androidprojecttemplate.ui.theme.ThemeRepository
import ir.kazemcodes.androidprojecttemplate.ui.theme.ThemeRepositoryImpl
import org.koin.dsl.module


val AppModule = module {
    single<ThemeRepository> {
        ThemeRepositoryImpl()
    }

}