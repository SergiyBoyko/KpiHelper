package ua.devserhii.kpihelper.global.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.view_progress_lesson.view.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.withAlpha
import ua.devserhii.kpihelper.R
import ua.devserhii.kpihelper.global.extensions.status
import ua.devserhii.kpihelper.global.model.LessonStatus
import ua.devserhii.kpihelper.pages.main.timetable.models.Lesson

/**
 * Created by Serhii Boiko on 30.06.2019.
 */
class ProgressLessonView : FrameLayout {
    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView()
    }

    private fun initView() {
        addView(View.inflate(context, R.layout.view_progress_lesson, null))
    }

    fun bindProgressLesson(lesson: Lesson) {
        lesson.status { status, minutes, percent ->
            lesson_progress.progress = percent
            lesson_time.text = if (minutes / 60 > 1) {
                "${minutes / 60}h"
            } else {
                "${minutes}m"
            }
            lesson_status.text = resources.getString(
                    R.string.lesson_status,
                    resources.getString(status.status)
            )
            lesson_location.text = resources.getString(
                    R.string.lesson_time_location,
                    lesson.lessonRoom,
                    lesson.lessonType,
                    lesson.timeStart.substring(0, 5),
                    lesson.timeEnd.substring(0, 5)
            )
            lesson_teacher.text = lesson.teacherName
            lesson_number.text = lesson.lessonNumber.toString()
            lesson_name.text = lesson.lessonName
            lesson_time_status.text = resources.getText(status.timeText)
            if (status == LessonStatus.IN_PROGRESS) {
                lesson_progress_container.backgroundColor = ContextCompat
                        .getColor(context, R.color.colorAccent).withAlpha(0x1A)
            }
        }
    }
}