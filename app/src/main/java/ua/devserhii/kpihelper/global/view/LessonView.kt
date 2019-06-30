package ua.devserhii.kpihelper.global.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.view_lesson.view.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.textColor
import org.jetbrains.anko.withAlpha
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
        addView(View.inflate(context, R.layout.view_lesson, null))
    }

    fun bindLesson(lesson: Lesson, now: Boolean) {
        if (now) {
            backgroundColor = ContextCompat.getColor(context, R.color.colorAccent).withAlpha(0x1A)
            val textColor = ContextCompat.getColor(context, R.color.colorAccent)
            lesson_number.textColor = textColor
            lesson_name.textColor = textColor
            lesson_location.textColor = textColor
        }

        lesson_number.text = lesson.lessonNumber.toString()
        lesson_name.text = lesson.lessonName
        val roomAndType = "${lesson.lessonRoom} ${lesson.lessonType}"
        lesson_location.text = roomAndType
    }
}