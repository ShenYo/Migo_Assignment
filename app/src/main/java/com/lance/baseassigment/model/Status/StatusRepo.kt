package com.lance.baseassigment.model.Status

import com.lance.baseassigment.domain.Status
import io.reactivex.Single
import org.koin.core.KoinComponent

/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2021/8/29
 */

interface StatusRepo {
    fun getStatus(): Single<Status>
}


class StatusRepoImpl(
    private val remoteDataSource: StatusApiService
) : StatusRepo, KoinComponent {

    override fun getStatus(): Single<Status> {
        return remoteDataSource.fetchStatus()
    }
}