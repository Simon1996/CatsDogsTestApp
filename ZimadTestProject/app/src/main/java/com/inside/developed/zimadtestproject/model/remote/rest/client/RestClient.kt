package com.inside.developed.zimadtestproject.model.remote.rest.client

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClient {
    fun getRetrofit(): Retrofit = Retrofit.Builder()
            .apply {
                baseUrl("http://kot3.com/xim/")
                client(createHttpClient())
                addConverterFactory(GsonConverterFactory.create())
                addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            }.build()

    private fun createHttpClient() = OkHttpClient.Builder()
            .apply {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                        .apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }
                addInterceptor(httpLoggingInterceptor)
            }.build()
}