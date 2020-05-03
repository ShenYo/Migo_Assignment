package com.lance.baseassigment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.lance.baseassigment.utils.showMessageToUser
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2020/5/4
 */


abstract class BaseFragment : Fragment() {

    private val disposables = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    protected fun addDisposable(d: Disposable) {
        disposables.add(d)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
        disposables.clear()
    }

    open fun showError(e: Throwable) {
        e.printStackTrace()
        showError(e.message.orEmpty())
    }

    open fun showError(message: String) {
        activity?.showMessageToUser(message)
    }
}