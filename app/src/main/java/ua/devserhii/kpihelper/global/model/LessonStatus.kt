package ua.devserhii.kpihelper.global.model

import ua.devserhii.kpihelper.R

/**
 * Created by Serhii Boiko on 30.06.2019.
 */
enum class LessonStatus(val status: Int, val timeText: Int) {
    PENDING(R.string.pending, R.string.start_in),
    PREPARATION(R.string.preparation, R.string.start_in),
    IN_PROGRESS(R.string.in_progress, R.string.end_in),
    COMPLETED(R.string.completed, R.string.ago);
}