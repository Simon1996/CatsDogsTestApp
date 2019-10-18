package com.inside.developed.zimadtestproject.util.extensions

import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inside.developed.zimadtestproject.core.base.BaseAdapter
import com.squareup.picasso.Picasso


inline fun <reified T : RecyclerView,
        reified A : BaseAdapter<*, *>,
        reified L : LinearLayoutManager> T.initialize(
    adapter: A, linearLayoutManager: L, init: T.() -> Unit = {}
) {
    layoutManager = linearLayoutManager
    setHasFixedSize(true)
    this.adapter = adapter
    init()
}

fun AppCompatImageView.loadFromUrl(url: String?) {
    Picasso
        .with(context)
        .load(url)
        .into(this)
}