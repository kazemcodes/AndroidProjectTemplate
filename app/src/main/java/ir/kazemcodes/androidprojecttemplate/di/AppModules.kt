package ir.kazemcodes.androidprojecttemplate.di

import android.app.Application
import android.content.Context
import com.squareup.sqldelight.db.SqlDriver
import ir.kazemcodes.androidprojecttemplate.Database
import ir.kazemcodes.androidprojecttemplate.data.db.utils.*
import ir.kazemcodes.androidprojecttemplate.domain.core.prefs.AndroidPreferenceStore
import ir.kazemcodes.androidprojecttemplate.domain.core.prefs.PreferenceStore
import okio.FileSystem
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Single

@org.koin.core.annotation.Module
@ComponentScan("ir.kazemcodes.androidprojecttemplate")
class AppModules {


    @Single
    fun provideSqlDrive(
        app:Application
    ) : SqlDriver {
        return DatabaseDriverFactory(app).create()
    }
    @Single
    fun provideDatabase(driver:SqlDriver): Database {
        return createDatabase(driver)
    }
    @Single
    fun databaseHandler(driver:SqlDriver, db: Database) : DatabaseHandler {
        return             AndroidDatabaseHandler(
            driver = driver,
            db = db
        )
    }


        @Single
    fun provideFileSystem(): FileSystem {
        return FileSystem.SYSTEM
    }
    @Single
    fun androidTransaction(driver:SqlDriver, db: Database) : AndroidDatabaseHandler {
        return AndroidDatabaseHandler(
            driver = driver,
            db = db
        )
    }
    @Single
    fun provideTransaction(handler: AndroidDatabaseHandler) : Transactions {
        return AndroidTransaction(handler)
    }

    @Single
    fun providePreferencesStore(context: Context): PreferenceStore {
        return AndroidPreferenceStore(context = context, "ui")
    }
}
