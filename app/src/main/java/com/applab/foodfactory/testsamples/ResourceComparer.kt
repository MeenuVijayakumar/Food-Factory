package com.applab.foodfactory.testsamples

import android.content.Context

class ResourceComparer {
    fun isEqualStringResource(context: Context, id: Int, str: String): Boolean {
      return  context.getString(id) == str
    }
}