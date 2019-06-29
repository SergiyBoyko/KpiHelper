package ua.devserhii.kpihelper.pages.main.timetable.models

import com.google.gson.annotations.SerializedName

data class Week(

        @SerializedName("week_number") val week_number: Int,
        @SerializedName("days") val days: Days
)