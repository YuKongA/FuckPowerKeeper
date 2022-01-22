buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.6.10"
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        //noinspection AndroidGradlePluginVersion,GradleDependency
        classpath("com.android.tools.build:gradle:7.2.0-alpha07")
        classpath(kotlin("gradle-plugin", kotlin_version))

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module settings.gradle.kts files
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}