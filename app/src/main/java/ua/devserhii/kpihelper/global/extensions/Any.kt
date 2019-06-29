package ua.devserhii.kpihelper.global.extensions

import com.google.gson.GsonBuilder

/**
 * Created by Serhii Boiko on 28.06.2019.
 */

fun Any.toGsonString(): String = GsonBuilder().create().toJson(this)