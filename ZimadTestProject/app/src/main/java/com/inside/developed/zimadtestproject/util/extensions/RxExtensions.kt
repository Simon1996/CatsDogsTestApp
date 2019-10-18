package com.inside.developed.zimadtestproject.util.extensions

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun <T> Single<T>.threadingSubscribe() = subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())