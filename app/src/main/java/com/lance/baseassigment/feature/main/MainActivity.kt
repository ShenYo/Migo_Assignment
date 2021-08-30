package com.lance.baseassigment.feature.main

import android.os.Bundle
import com.lance.baseassigment.R
import com.lance.baseassigment.base.BaseActivity
import com.lance.baseassigment.domain.StatusDomain
import com.lance.baseassigment.model.Status.StatusApiService
import com.lance.baseassigment.utils.NetworkStatusProvider
import com.lance.baseassigment.utils.applySchedulers
import com.lance.baseassigment.utils.showMessageToUser
import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.inject
import org.koin.java.KoinJavaComponent.inject

/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2020/5/4
 */


class MainActivity : BaseActivity(), KoinComponent {

    private val viewModel: MainViewModel by inject()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addDisposable(
            viewModel.getNetworkStatus()
                .applySchedulers()
                .subscribe({
                    showMessageToUser(it.toString())
                }, {
                    showError(it)
                })
        )
    }
}