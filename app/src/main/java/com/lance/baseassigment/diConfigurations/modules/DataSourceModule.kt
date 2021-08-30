package com.lance.baseassigment.diConfigurations.modules

import com.lance.baseassigment.model.Status.StatusApiService
import com.lance.baseassigment.model.Status.StatusRepo
import com.lance.baseassigment.model.Status.StatusRepoImpl
import com.lance.baseassigment.utils.NetworkStatusProvider
import org.koin.core.qualifier.named
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module
import org.koin.ext.getScopeName
import retrofit2.Retrofit

/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2021/8/29
 */

val datasourceModule = module {
    single<StatusRepo> {
        StatusRepoImpl(get())
    }
    single {
        return@single when (get<NetworkStatusProvider>().connectionType()) {
            NetworkStatusProvider.NetworkType.CELLULAR -> {
                 get<Retrofit>(named(ServerEnvironment.PUBLIC)).create(StatusApiService::class.java)
            }
            else -> {
                get<Retrofit>(named(ServerEnvironment.PRIVATE)).create(StatusApiService::class.java)
            }
        }
    }
}