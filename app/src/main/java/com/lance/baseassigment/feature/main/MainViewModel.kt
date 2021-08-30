package com.lance.baseassigment.feature.main

import androidx.lifecycle.ViewModel
import com.lance.baseassigment.domain.StatusDomain
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2021/8/29
 */


class MainViewModel : ViewModel(), KoinComponent {

    private val statusDomain: StatusDomain by inject()

    fun getNetworkStatus(): Single<StatusViewData> {
        return statusDomain.checkNetworkStatus().map {
            StatusViewData(it.status, it.message)
        }
    }
}

data class StatusViewData(
    val status: Int,
    val message: String
)
