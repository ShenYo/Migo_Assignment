package com.lance.baseassigment.networkStatus

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.lance.baseassigment.utils.NetworkStatusProvider
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import junit.framework.Assert.assertEquals
import org.junit.Before

import org.junit.Test
import org.koin.test.KoinTest

/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2021/8/29
 */

class NetworkStatusTest : KoinTest {

    @RelaxedMockK
    lateinit var connectivityManager: ConnectivityManager

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun Test_NetworkProvider_return_value_when_connecting_with_WIFI() {
        every {
            connectivityManager.getNetworkCapabilities(any())
                ?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
        } returns true

        val networkStatusProvider = NetworkStatusProvider(connectivityManager)
        assertEquals(
            NetworkStatusProvider.NetworkType.WIFI,
            networkStatusProvider.connectionType()
        )
    }

    @Test
    fun Test_NetworkProvider_return_value_when_connecting_with_CELLULAR() {
        every {
            connectivityManager.getNetworkCapabilities(any())
                ?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
        } returns true
        val networkStatusProvider = NetworkStatusProvider(connectivityManager)

        assertEquals(
            NetworkStatusProvider.NetworkType.CELLULAR,
            networkStatusProvider.connectionType()
        )
    }

}