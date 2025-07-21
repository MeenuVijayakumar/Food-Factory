package com.applab.foodfactory.utils

import android.view.View

val View.dp : Float
    get() = context.dp

fun View.setCornerRadius(radiusPx: Float = Float.MAX_VALUE) {
    val outline =
        outlineProvider as? RoundedRectOutlineProvider ?: RoundedRectOutlineProvider(radiusPx)
    outline.radius = radiusPx
    outlineProvider = outline
    clipToOutline = true
}