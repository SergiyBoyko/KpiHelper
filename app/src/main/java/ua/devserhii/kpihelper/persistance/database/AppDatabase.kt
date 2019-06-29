package ua.devserhii.kpihelper.persistance.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ua.devserhii.kpihelper.pages.main.timetable.models.Timetable
import ua.devserhii.kpihelper.pages.main.timetable.persistance.local.TimetableDao

/**
 * Created by Serhii Boiko on 28.06.2019.
 */
@Database(entities = [Timetable::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun timetableDao(): TimetableDao
}