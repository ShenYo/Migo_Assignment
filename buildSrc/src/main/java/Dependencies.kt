/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2020/5/3
 */


object Dependencies {

    const val gradle = "com.android.tools.build:gradle:${Versions.Gradle.core}"
    const val gradleKotlinPlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Gradle.kotlinPlugin}"

    object Kotlin {
        const val core = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Kotlin.core}"
        const val extension =
            "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Kotlin.extensions}"
    }


    object Android {
        const val appCompact = "androidx.appcompat:appcompat:${Versions.Android.appCompact}"
    }

    object ReactivePrograming {
        const val RxJava = "io.reactivex.rxjava3:rxjava:${Versions.ReactivePrograming.RxJava}"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Network.retrofit}"
    }

    object Database {
        object Room {
            const val core = "androidx.room:room-runtime:${Versions.Database.room}"
            const val compiler = "androidx.room:room-compiler:${Versions.Database.room}"
            const val kotlin_extension = "androidx.room:room-ktx:${Versions.Database.room}"
            const val rxjava = "androidx.room:room-rxjava2:${Versions.Database.room}"
        }
    }

    object ImageLoader {
        const val glide = "com.github.bumptech.glide:glide:${Versions.ImageLoader.glide}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.Test.junit}"
        const val room_helper = "androidx.room:room-testing:${Versions.Database.room}"
    }

    object AndroidTests {
        const val junit = "androidx.test.ext:junit:${Versions.AndroidTest.junit}"
        const val espresso =
            "androidx.test.espresso:espresso-core:${Versions.AndroidTest.espresso}"
    }

}