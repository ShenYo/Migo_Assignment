package com.lance.baseassigment.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.lance.baseassigment.utils.showMessageToUser
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2020/5/4
 */


abstract class BaseActivity : AppCompatActivity() {

    private val disposables = CompositeDisposable()

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    protected fun addDisposable(d: Disposable) {
        disposables.add(d)
    }

    open fun showError(e: Throwable) {
        e.printStackTrace()
        showError(e.message.orEmpty())
    }

    open fun showError(message: String) {
        if (!message.isNullOrBlank()) {
            showMessageToUser(message)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
        disposables.clear()
    }

}
