package com.applab.foodfactory.utils

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider
import androidx.annotation.Px
import kotlin.math.min

class RoundedRectOutlineProvider(@param:Px var radius: Float) : ViewOutlineProvider() {
    override fun getOutline(p0: View?, p1: Outline?) {
        if (p0 != null && p1 != null) {
            val maxRadius = min(p0.width, p0.height) / 2f
            p1.setRoundRect(
                0, 0,
                p0.width, p0.height,
                min(radius, maxRadius)
            )
        }
    }
}