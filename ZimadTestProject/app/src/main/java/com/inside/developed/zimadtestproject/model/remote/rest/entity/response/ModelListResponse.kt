package com.inside.developed.zimadtestproject.model.remote.rest.entity.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelListResponse(
    var message: String? = null,
   var data: ArrayList<CatsDogsModel>? = null
): Parcelable

@Parcelize
data class CatsDogsModel(val url: String? = null, val title: String? = null) : Parcelable


