package ua.devserhii.kpihelper.pages.main.timetable.persistance.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ua.devserhii.kpihelper.pages.main.timetable.models.Timetable

/**
 * Created by Serhii Boiko on 28.06.2019.
 */
@Dao
interface TimetableDao {
    @Query("SELECT * FROM Timetable")
    fun getCurrent(): Timetable

    @Insert
    fun insertCurrent(timetable: Timetable)

    @Delete
    fun delete(timetable: Timetable)
}