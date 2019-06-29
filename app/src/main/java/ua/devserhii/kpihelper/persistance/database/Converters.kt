package ua.devserhii.kpihelper.persistance.database

import androidx.room.TypeConverter
import ua.devserhii.kpihelper.global.extensions.parse
import ua.devserhii.kpihelper.global.extensions.toGsonString
import ua.devserhii.kpihelper.pages.main.timetable.models.Weeks
import ua.devserhii.kpihelper.pages.start.models.Group

/**
 * Created by Serhii Boiko on 28.06.2019.
 */
class Converters {
    @TypeConverter
    fun toGroup(string: String): Group = string.parse()

    @TypeConverter
    fun groupToString(region: Group): String = region.toGsonString()

    @TypeConverter
    fun toWeeks(string: String): Weeks = string.parse()

    @TypeConverter
    fun weeksToString(region: Weeks): String = region.toGsonString()
}