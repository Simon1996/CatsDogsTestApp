package com.inside.developed.zimadtestproject.util.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.provider.SyncStateContract

const val EXTRA = "extra"

inline fun <reified T : Activity> Activity.startActivity(toFlag: Int? = null,
                                                         extra: Parcelable? = null) =
        startActivity(createIntent<T>(toFlag, extra))

inline fun <reified T : Activity> Activity.startActivityWithResult(toFlag: Int? = null,
                                                                   extra: Parcelable? = null,
                                                                   code: Int) =
        startActivityForResult(createIntent<T>(toFlag, extra), code)

inline fun <reified T : Parcelable?> Activity.getData(): T = intent!!.extras!!
        .getParcelable<T>(EXTRA)!!

inline fun <reified T : Activity> Context.createIntent(toFlag: Int? = null, extra: Parcelable? = null) =
    Intent(this, T::class.java).apply {
        toFlag?.let { flags = it }
        extra?.let { putExtra(EXTRA, extra) }
    }