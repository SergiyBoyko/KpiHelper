package ua.devserhii.kpihelper.global.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Serhii Boiko on 22.06.2019.
 */
data class KpiResponse<T>(
    @SerializedName("statusCode") val statusCode: Int,
    @SerializedName("timeStamp") val timeStamp: Int,
    @SerializedName("message") val message: String,
    @SerializedName("debugInfo") val debugInfo: String,
    @SerializedName("meta") val meta: Meta,
    @SerializedName("data") val data: T
)