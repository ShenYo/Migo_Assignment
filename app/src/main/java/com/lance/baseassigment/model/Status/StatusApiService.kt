package com.lance.baseassigment.model.Status

import com.lance.baseassigment.domain.Status
import io.reactivex.Single
import org.koin.core.KoinComponent
import retrofit2.http.GET

/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2021/8/29
 */


interface StatusApiService {

    private object Endpoint {
        const val STATUS = "/status"
    }

    @GET(Endpoint.STATUS)
    fun fetchStatus(): Single<Status>
}
