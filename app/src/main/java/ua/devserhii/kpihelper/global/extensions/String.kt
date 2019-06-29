package ua.devserhii.kpihelper.global.extensions

import com.google.gson.GsonBuilder

/**
 * Created by Serhii Boiko on 28.06.2019.
 */

inline fun <reified T> String.parse(): T = GsonBuilder().create().fromJson<T>(this, T::class.java)