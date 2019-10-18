package com.inside.developed.zimadtestproject.model.remote.rest.api

import androidx.annotation.Keep
import com.inside.developed.zimadtestproject.model.remote.rest.entity.response.ModelListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header

@Keep
interface NetworkApi {
    @GET(value = "api.php?query=cat")
    fun getCats(): Single<ModelListResponse>

    @GET(value = "api.php?query=dog")
    fun getDogs(): Single<ModelListResponse>
}