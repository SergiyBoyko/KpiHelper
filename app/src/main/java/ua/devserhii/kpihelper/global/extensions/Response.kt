package ua.devserhii.kpihelper.global.extensions

import android.util.Log
import retrofit2.Response
import ua.devserhii.kpihelper.global.model.KpiResponse

fun <T> Response<T>.getHandledBody(): T {
    if (isSuccessful) {
        body()?.let { return it }
            ?: throw Exception()
    } else {
        throw Exception()
    }
}

fun <T> Response<KpiResponse<T>>.getHandledData(): T {
    if (isSuccessful) {
        body()?.let { response -> return response.data.also { Log.d("HANDLED_DATA", it.toString()) } }
            ?: throw Exception("Empty body")
    } else {
        throw Exception("Request not successful")
    }
}
