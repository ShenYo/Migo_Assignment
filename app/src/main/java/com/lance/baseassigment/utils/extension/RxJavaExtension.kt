package com.lance.baseassigment.utils

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2021/8/29
 */

fun <T> Single<T>.applySchedulers(): Single<T> {
    return this
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}
