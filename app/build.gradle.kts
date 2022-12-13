
plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.yuk.fuckMiuiFps"
        minSdk = 28
        targetSdk = 33
        versionCode = 12
        versionName = "1.2"
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