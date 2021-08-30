package com.lance.baseassigment.domain

import com.lance.baseassigment.model.Status.StatusRepo
import io.reactivex.Single

import com.lance.baseassigment.utils.NetworkStatusProvider
import org.koin.core.KoinComponent
import org.koin.java.KoinJavaComponent.inject


/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2021/8/29
 */

//TODO: business logic not clear yet, following api spec first
data class Status(
    val status: Int,
    val message: String
)

interface StatusDomain {
    fun checkNetworkStatus(): Single<Status>
}

class StatusDomainImpl(
    private val statusRepo: StatusRepo
) : StatusDomain, KoinComponent {

    override fun checkNetworkStatus(): Single<Status> = statusRepo.getStatus()
}