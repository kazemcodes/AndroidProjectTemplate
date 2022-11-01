package ir.kazemcodes.androidprojecttemplate

import android.app.Application
import ir.kazemcodes.androidprojecttemplate.di.AppModule
import ir.kazemcodes.androidprojecttemplate.di.AppModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.module


class MyApp : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            androidLogger()
            modules(
                AppModules().module,
                AppModule

            )
        }

    }
}