package com.inside.developed.zimadtestproject.core.domain.repository.login

import com.inside.developed.zimadtestproject.model.remote.NetworkRepository
import com.inside.developed.zimadtestproject.model.remote.rest.entity.response.ModelListResponse
import io.reactivex.Single

class MainRepositoryImpl(private val networkRepository: NetworkRepository) : MainRepository {
    override fun getCats(): Single<ModelListResponse> = networkRepository.getCats()

    override fun getDogs(): Single<ModelListResponse> = networkRepository.getDogs()
}