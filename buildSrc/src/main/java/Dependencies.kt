/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2020/5/3
 */


object Dependencies {

    //kotlin
    const val kotlinCore = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Kotlin.core}"
    const val kotlinExtension =
        "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Kotlin.extensions}"

    //android
    const val androidAppCompact = "androidx.appcompat:appcompat:${Versions.Android.appCompact}"

    //test
    const val test_junit = "junit:junit:${Versions.Test.junit}"

    //androidTests
    const val androidTest_junit = "androidx.test.ext:junit:${Versions.AndroidTest.junit}"
    const val androidTest_espresso = "androidx.test.espresso:espresso-core:${Versions.AndroidTest.espresso}"

}