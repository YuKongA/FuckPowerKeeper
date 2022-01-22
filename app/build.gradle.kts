
plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = 32
    buildToolsVersion = "32.0.0"
    defaultConfig {
        applicationId = "com.yuk.fuckMiuiFps"
        minSdk = 28
        targetSdk = 32
        versionCode = 11
        versionName = "1.1"
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isZipAlignEnabled = true
            setProguardFiles(listOf(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro", "proguard-log.pro"))
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    packagingOptions {
        dex {
            useLegacyPackaging = true
        }
    }
}

dependencies {
    compileOnly("de.robv.android.xposed:api:82")
}