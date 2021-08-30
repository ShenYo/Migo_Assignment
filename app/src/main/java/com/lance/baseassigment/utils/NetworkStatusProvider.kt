package com.lance.baseassigment.utils

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import org.koin.core.KoinComponent

/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2021/8/29
 */


class NetworkStatusProvider(private val connectivityManager: ConnectivityManager) : KoinComponent {

    enum class NetworkType {
        WIFI, CELLULAR, BOTH, NONE
    }

    fun connectionType(): NetworkType {
        val cm = connectivityManager
        return cm.getNetworkCapabilities(cm.activeNetwork).run {
            when {
                //TODO: AFAIK, we won't have a case to use two network type at the same time
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                        && hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    NetworkType.BOTH
                }
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    NetworkType.CELLULAR
                }
                hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    NetworkType.WIFI
                }
                else -> NetworkType.NONE
            }
        }
    }
}