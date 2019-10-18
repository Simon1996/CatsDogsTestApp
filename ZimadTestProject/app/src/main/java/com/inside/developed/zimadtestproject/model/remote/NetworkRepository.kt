package com.inside.developed.zimadtestproject.model.remote

import com.inside.developed.zimadtestproject.model.remote.rest.entity.response.ModelListResponse
import io.reactivex.Single

interface NetworkRepository {
    fun getCats(): Single<ModelListResponse>

    fun getDogs(): Single<ModelListResponse>
}