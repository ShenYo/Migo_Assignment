package com.lance.baseassigment

import android.app.Application
import com.lance.baseassigment.diConfigurations.modules.*
import com.lance.baseassigment.diConfigurations.modules.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2020/5/4
 */


class AppContext : Application() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        startKoin {
            androidContext(this@AppContext)
            modules(
                mainPageModule, networkModule, datasourceModule, domainModule, utilModule
            )
        }
    }
}