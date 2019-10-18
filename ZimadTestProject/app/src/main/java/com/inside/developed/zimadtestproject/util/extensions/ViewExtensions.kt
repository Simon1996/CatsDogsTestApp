package com.inside.developed.zimadtestproject.util.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inside.developed.zimadtestproject.core.base.BaseAdapter
import com.squareup.picasso.Picasso


private object NameResolver {
    private val packageName = NameResolver::class.java.`package`

    val preferenceKey = "$packageName.preference"
}

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

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