package ua.devserhii.kpihelper.pages.main.timetable.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import ua.devserhii.kpihelper.pages.start.models.Group
import ua.devserhii.kpihelper.persistance.database.Converters

@Entity
@TypeConverters(Converters::class)
data class Timetable(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @SerializedName("group") val group: Group,
        @SerializedName("weeks") val weeks: Weeks
)