package com.applab.foodfactory.utils

import android.content.Context
import android.content.res.Resources
import androidx.fragment.app.Fragment

val Context.dp: Float
    get() = resources.displayMetrics.density

val Fragment.dp: Float
    get() = resources.displayMetrics.density

fun Float.toPx() = this * (Resources.getSystem().displayMetrics.density)