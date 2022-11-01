buildscript {
    repositories {
        mavenCentral()
        google()
        maven("https://plugins.gradle.org/m2/")
        gradlePluginPortal()
    }
    dependencies {
        classpath(libs.gradle.tools)
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {


    alias(libs.plugins.android) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.library) apply false
    alias(libs.plugins.kotlinSerilization) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.sqldelight) apply false
}