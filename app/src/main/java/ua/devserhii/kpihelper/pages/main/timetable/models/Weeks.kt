package ua.devserhii.kpihelper.pages.main.timetable.models

import com.google.gson.annotations.SerializedName

data class Weeks(
        @SerializedName("1") val firstWeek: Week,
        @SerializedName("2") val secondWeek: Week
)