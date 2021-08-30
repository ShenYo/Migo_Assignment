plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("koin")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.3"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    defaultConfig {
        applicationId = "com.lance.baseassigment"
        minSdkVersion(23)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "PUBLIC_API_ROOT", "\"https://code-test.migoinc-dev.com\"")
        buildConfigField("String", "PRIVATE_API_ROOT", "\"https://192.168.2.2\"")
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

    implementation(Dependencies.Kotlin.core)
    implementation(Dependencies.Kotlin.extension)
    implementation(Dependencies.Android.appCompact)
    implementation(Dependencies.Android.constraintLayout)
    implementation(Dependencies.ReactivePrograming.RxJava)
    implementation(Dependencies.ReactivePrograming.RxAndroid)
    implementation(Dependencies.Network.Retrofit.retrofit)
    implementation(Dependencies.Network.Retrofit.adapterRxJava2)
    implementation(Dependencies.Network.Retrofit.gsonConvertor)

    implementation(Dependencies.ImageLoader.glide)

    implementation(Dependencies.DependencyInjection.Koin.core)
    implementation(Dependencies.DependencyInjection.Koin.android)
    implementation(Dependencies.DependencyInjection.Koin.androidViewModel)
    implementation(Dependencies.DependencyInjection.Koin.androidScope)

    implementation(Dependencies.Logger.timber)

    testImplementation(Dependencies.Test.junit)
    testImplementation(Dependencies.Test.mockk)
    testImplementation(Dependencies.Test.koin_helper)

    androidTestImplementation(Dependencies.AndroidTests.junit)
    androidTestImplementation(Dependencies.Test.mockk_Android)
    androidTestImplementation(Dependencies.Test.koin_helper)
    androidTestImplementation(Dependencies.AndroidTests.testRules)
    androidTestImplementation(Dependencies.AndroidTests.testRunner)
}
