package com.lance.baseassigment.diConfigurations.modules

import com.lance.baseassigment.feature.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2021/8/29
 */


val mainPageModule = module {
    viewModel {
        MainViewModel()
    }
}