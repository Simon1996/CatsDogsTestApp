package com.inside.developed.zimadtestproject.core.di

import com.inside.developed.zimadtestproject.core.domain.repository.login.MainRepository
import com.inside.developed.zimadtestproject.core.domain.repository.login.MainRepositoryImpl
import com.inside.developed.zimadtestproject.core.domain.viewmodel.MainViewModel
import com.inside.developed.zimadtestproject.model.remote.NetworkRepository
import com.inside.developed.zimadtestproject.model.remote.NetworkRepositoryImpl
import com.inside.developed.zimadtestproject.model.remote.rest.client.RestClient
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viesModule = module {
    single { MainViewModel(get()) }
}

val repoModule = module {
    factory { MainRepositoryImpl(get()) as MainRepository }
}

val netModule = module {
    factory { RestClient() }
    factory { NetworkRepositoryImpl(get()) as NetworkRepository }
}