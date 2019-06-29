package ua.devserhii.kpihelper.global.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.view_lesson.view.*
import ua.devserhii.kpihelper.R
import ua.devserhii.kpihelper.pages.main.timetable.models.Lesson

/**
 * Created by Serhii Boiko on 29.06.2019.
 */
class LessonView : FrameLayout {
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
        val view = View.inflate(context, R.layout.view_lesson, null)
        addView(view)
    }

    fun bindLesson(lesson: Lesson) {
        lesson_number.text = lesson.lessonNumber.toString()
        lesson_name.text = lesson.lessonName
        val roomAndType = "${lesson.lessonRoom} ${lesson.lessonType}"
        lesson_location.text = roomAndType
    }
}