package com.lance.baseassigment.diConfigurations.modules

import android.content.Context
import android.net.ConnectivityManager
import com.lance.baseassigment.utils.NetworkStatusProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2021/8/29
 */


val utilModule = module {
    single { NetworkStatusProvider(get()) }
    single { androidApplication().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
}