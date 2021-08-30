package com.lance.baseassigment.diConfigurations.modules

import com.lance.baseassigment.domain.StatusDomain
import com.lance.baseassigment.domain.StatusDomainImpl
import org.koin.dsl.module

/**
 * Description:
 *
 * @author lance.wang
 * @version 1.0, 2021/8/29
 */


val domainModule = module {
    single<StatusDomain> {
        StatusDomainImpl(get())
    }
}