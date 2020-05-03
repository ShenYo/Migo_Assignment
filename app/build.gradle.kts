
plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.2"

    defaultConfig {
        applicationId = "com.lance.baseassigment"
        minSdkVersion(23)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation(Dependencies.kotlinCore)
    implementation(Dependencies.androidAppCompact)
    implementation(Dependencies.kotlinExtension)

    testImplementation(Dependencies.test_junit)

    androidTestImplementation(Dependencies.androidTest_junit)
    androidTestImplementation(Dependencies.androidTest_espresso)
}
