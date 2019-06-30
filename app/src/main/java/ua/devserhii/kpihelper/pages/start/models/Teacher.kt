package ua.devserhii.kpihelper.pages.start.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Serhii Boiko on 30.06.2019.
 */
data class Teacher(
        @SerializedName("teacher_id") val teacherId: Int,
        @SerializedName("teacher_name") val teacherName: String,
        @SerializedName("teacher_full_name") val teacherFullName: String,
        @SerializedName("teacher_short_name") val teacherShortName: String,
        @SerializedName("teacher_url") val teacherUrl: String,
        @SerializedName("teacher_rating") val teacherRating: Double
)