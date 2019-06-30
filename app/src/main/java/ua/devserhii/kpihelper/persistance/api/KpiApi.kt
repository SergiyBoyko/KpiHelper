package ua.devserhii.kpihelper.persistance.api

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ua.devserhii.kpihelper.global.model.KpiResponse
import ua.devserhii.kpihelper.pages.main.timetable.models.Timetable
import ua.devserhii.kpihelper.pages.start.models.Group
import ua.devserhii.kpihelper.pages.start.models.Teacher

/**
 * Created by Serhii Boiko on 23.06.2019.
 */
interface KpiApi {
    @GET(SEARCH_GROUP)
    fun searchGroupAsync(@Query("search") text: String)
            : Deferred<Response<KpiResponse<List<Group>>>>

    @GET(SEARCH_TEACHER)
    fun searchTeacherAsync(@Query("search") text: String)
            : Deferred<Response<KpiResponse<List<Teacher>>>>

    @GET(FETCH_TIMETABLE)
    fun fetchTimetableAsync(@Path("groupName") groupName: String)
            : Deferred<Response<KpiResponse<Timetable>>>

    @GET(WEEK_NUMBER)
    fun fetchWeekNumberAsync()
            : Deferred<Response<KpiResponse<Int>>>
}