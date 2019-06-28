package ua.devserhii.kpihelper.global.view

import android.content.Context
import android.util.AttributeSet
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.widget.AutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout


/**
 * Created by Serhii Boiko on 28.06.2019.
 */
class TextInputAutoCompleteTextView : AutoCompleteTextView {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onCreateInputConnection(outAttrs: EditorInfo?): InputConnection {
        val ic = super.onCreateInputConnection(outAttrs)
        if (ic != null && outAttrs?.hintText == null) {
            val parent = parent
            if (parent is TextInputLayout) {
                outAttrs?.hintText = parent.hint
            }
        }
        return ic
    }
}