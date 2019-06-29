package ua.devserhii.kpihelper.pages.main.timetable.models

import com.google.gson.annotations.SerializedName

data class Rooms(

        @SerializedName("room_id") val roomId: Int,
        @SerializedName("room_name") val roomName: String,
        @SerializedName("room_latitude") val roomLatitude: Double,
        @SerializedName("room_longitude") val roomLongitude: Double
)