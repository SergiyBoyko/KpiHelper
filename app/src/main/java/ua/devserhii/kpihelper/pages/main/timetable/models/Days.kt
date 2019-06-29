package ua.devserhii.kpihelper.pages.main.timetable.models

import com.google.gson.annotations.SerializedName

data class Days(

        @SerializedName("1") val monday: Day,
        @SerializedName("2") val tuesday: Day,
        @SerializedName("3") val wednesday: Day,
        @SerializedName("4") val thursday: Day,
        @SerializedName("5") val friday: Day,
        @SerializedName("6") val saturday: Day
)