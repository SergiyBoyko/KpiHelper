package ua.devserhii.kpihelper.pages.start.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Serhii Boiko on 23.06.2019.
 */
data class Group(
    @SerializedName("group_id") val groupId: Int,
    @SerializedName("group_full_name") val groupFullName: String,
    @SerializedName("group_prefix") val groupPrefix: String,
    @SerializedName("group_okr") val groupOkr: String,
    @SerializedName("group_type") val groupType: String,
    @SerializedName("group_url") val groupUrl: String
)