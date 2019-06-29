package ua.devserhii.kpihelper.pages.main.timetable.models

import com.google.gson.annotations.SerializedName

data class Lesson(

        @SerializedName("lesson_id") val lessonId: Int,
        @SerializedName("group_id") val groupId: Int,
        @SerializedName("day_number") val dayNumber: Int,
        @SerializedName("day_name") val dayName: String,
        @SerializedName("lesson_name") val lessonName: String,
        @SerializedName("lesson_full_name") val lessonFullName: String,
        @SerializedName("lesson_number") val lessonNumber: Int,
        @SerializedName("lesson_room") val lessonRoom: String,
        @SerializedName("lesson_type") val lessonType: String,
        @SerializedName("teacher_name") val teacherName: String,
        @SerializedName("lesson_week") val lessonWeek: Int,
        @SerializedName("time_start") val timeStart: String,
        @SerializedName("time_end") val timeEnd: String,
        @SerializedName("rate") val rate: Int,
        @SerializedName("teachers") val teachers: List<Teachers>,
        @SerializedName("rooms") val rooms: List<Rooms>
)
