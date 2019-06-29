package ua.devserhii.kpihelper.pages.main.timetable.models

import com.google.gson.annotations.SerializedName

data class Teachers(

        @SerializedName("teacher_id") val teacher_id: Int,
        @SerializedName("teacher_name") val teacher_name: String,
        @SerializedName("teacher_full_name") val teacher_full_name: String,
        @SerializedName("teacher_short_name") val teacher_short_name: String,
        @SerializedName("teacher_url") val teacher_url: String,
        @SerializedName("teacher_rating") val teacher_rating: Double
)