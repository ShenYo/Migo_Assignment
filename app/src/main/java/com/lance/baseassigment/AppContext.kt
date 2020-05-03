package com.lance.baseassigment

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.core.module.Module

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
            listOf<Module>()
        }
    }
}