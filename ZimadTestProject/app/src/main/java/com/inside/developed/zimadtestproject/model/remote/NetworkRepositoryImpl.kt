package com.inside.developed.zimadtestproject.model.remote

import com.inside.developed.zimadtestproject.model.remote.rest.api.NetworkApi
import com.inside.developed.zimadtestproject.model.remote.rest.client.RestClient
import com.inside.developed.zimadtestproject.model.remote.rest.entity.response.ModelListResponse
import io.reactivex.Single

class NetworkRepositoryImpl(private var client: RestClient) : NetworkRepository {
    private val networkApi: NetworkApi by lazy {
        client.getRetrofit().create(NetworkApi::class.java)
    }

    override fun getCats(): Single<ModelListResponse> = networkApi.getCats()

    override fun getDogs(): Single<ModelListResponse> = networkApi.getDogs()
}