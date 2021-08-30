package com.lance.baseassigment.diConfigurations.modules

import com.google.gson.GsonBuilder
import com.lance.baseassigment.BuildConfig
import okhttp3.OkHttpClient
import org.koin.dsl.module
import org.koin.core.qualifier.named
import org.koin.ext.getScopeName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2021/8/28
 */
enum class ServerEnvironment {
    PUBLIC,
    PRIVATE
}

val networkModule = module {
    single { GsonConverterFactory.create(get()) }
    single { RxJava2CallAdapterFactory.create() }
    single {
        GsonBuilder()
            .serializeNulls()
            .create()
    }
    single(named(ServerEnvironment.PUBLIC)) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.PUBLIC_API_ROOT)
            .addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
            .addConverterFactory(get<GsonConverterFactory>())
            .client(get())
            .build()
    }
    single(named(ServerEnvironment.PRIVATE)) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.PRIVATE_API_ROOT)
            .addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
            .addConverterFactory(get<GsonConverterFactory>())
            .client(get())
            .build()
    }
    single {
        OkHttpClient.Builder()
            .build()
    }
}