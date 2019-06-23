package ua.devserhii.kpihelper.global.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Serhii Boiko on 23.06.2019.
 */
data class Meta(
    @SerializedName("total_count") val total_count: Int,
    @SerializedName("offset") val offset: Int,
    @SerializedName("limit") val limit: Int
)