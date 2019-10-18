package com.inside.developed.zimadtestproject.core.domain.repository.login

import com.inside.developed.zimadtestproject.model.remote.rest.entity.response.ModelListResponse
import io.reactivex.Single

interface MainRepository {
    fun getCats(): Single<ModelListResponse>

    fun getDogs(): Single<ModelListResponse>
}