package com.inside.developed.zimadtestproject.util.extensions

import android.content.Context
import android.content.Intent
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Context.getCompatColor(@ColorRes colorRes: Int) = ContextCompat.getColor(this, colorRes)

fun Fragment.getCompatColor(@ColorRes colorRes: Int) = requireContext().getCompatColor(colorRes)

fun Context.getCompatDrawable(@DrawableRes drawableRes: Int) = ContextCompat.getDrawable(this, drawableRes)

inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)
