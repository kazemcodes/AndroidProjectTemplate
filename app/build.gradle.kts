plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.serialization")
    id("com.google.devtools.ksp")
    id("com.squareup.sqldelight")
}

android {
    namespace = ProjectConfig.applicationId
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.applicationId
        minSdk =ProjectConfig.minSdk
        targetSdk =ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName =ProjectConfig.versionName
        testInstrumentationRunner ="androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility= JavaVersion.VERSION_11
        targetCompatibility =JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compiler.get()
    }
    packagingOptions {
        resources.excludes.addAll(
            listOf(
                "/META-INF/{AL2.0,LGPL2.1}"
            )
        )
    }
    androidComponents.onVariants { variant ->
        val name = variant.name
        sourceSets {
            getByName(name).kotlin.srcDir("${buildDir.absolutePath}/generated/ksp/${name}/kotlin")
        }
    }
    sourceSets {
        getByName("androidTest").assets.srcDir("$projectDir/schemas")
    }
    sqldelight {
        database("Database") {
            packageName = ProjectConfig.applicationId
            dialect = "sqlite:3.24"
            version = 1
            schemaOutputDirectory = file("src/main/sqldelight/databases")
            verifyMigrations = true
        }
    }
}

dependencies {
    implementation(libs.compose.ui)
    implementation(libs.compose.foundation)
    implementation(libs.compose.activity)
    implementation(libs.compose.material)
    implementation(libs.material3.core)
    implementation(libs.material3.windowsizeclass)
    implementation(libs.material.icons)
    implementation(libs.compose.navigation)
    implementation(libs.compose.lifecycle)
    implementation(libs.compose.runtime)
    implementation(libs.compose.uiToolingPreview)
    implementation(libs.compose.uiTooling)

    implementation(libs.coil.core)
    implementation(libs.coil.compose)

    implementation(libs.koin.annotations)
    ksp(libs.koin.kspCompiler)
    implementation(libs.koin.android)
    implementation(libs.koin.androidCompose)
    implementation(libs.koin.core)

    implementation(libs.accompanist.systemUiController)
    implementation(libs.accompanist.navAnimation)
    implementation(libs.accompanist.navMaterial)


    implementation(libs.sqldelight.android)
    implementation(libs.sqldelight.coroutines)
    implementation(libs.sqldelight.runtime)
    implementation(libs.sqldelight.android.paging)
    implementation(libs.requerySqlite)
    compileOnly(libs.androidSqlite)
    debugImplementation(libs.androidSqlite)


    api(libs.stdlib)
    api(libs.serialization.json)

    implementation(libs.dataStore)
    implementation(libs.dataStoreCore)
    implementation(libs.bundles.common)

    implementation(libs.destinations.core)
    ksp(libs.destinations.ksp)



}