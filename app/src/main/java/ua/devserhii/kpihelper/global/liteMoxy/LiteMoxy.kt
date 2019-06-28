package ua.devserhii.kpihelper.global.liteMoxy

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import java.util.*


abstract class MvpPresenter<T : Any> : KoinComponent {

    val view: MvpView<T> = BufferView()

    open fun attach(view: MvpView<T>) = (this.view as BufferView).attach(view)
    open fun detach() = (view as BufferView).detach()


    private class BufferView<T : Any> : MvpView<T> {

        private val buffer = ArrayList<T>()
        private var view: MvpView<T>? = null

        override fun update(event: T) {
            buffer.removeAll { it::class == event::class }
            if (view == null) buffer.add(event)
            CoroutineScope(Dispatchers.Main).launch { view?.update(event) }
        }

        fun attach(view: MvpView<T>) {
            buffer.forEach(view::update)
            buffer.clear()
            this.view = view
        }

        fun detach() {
            view = null
        }
    }
}

interface MvpView<T> {
    fun update(event: T)
}

abstract class MvpFragment<T : Any> : Fragment(), MvpView<T> {

    abstract val presenter: MvpPresenter<T>

    override fun onResume() {
        super.onResume()
        retainInstance = true
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }
}

abstract class MvpAppCompatActivity<T : Any> : AppCompatActivity(), MvpView<T> {

    abstract val presenter: MvpPresenter<T>

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        Log.d("CURR_LOCALE", resources.configuration.locale.toString())
//        Log.d("SHARED_LOCALE", App.instance.localeManager.currLocale)
//        App.instance.localeManager.updateBaseContextLocaleWithoutBus(App.instance.localeManager.currLocale, this)
//        Log.d("CURR_AFTER_LOCALE", resources.configuration.locale.toString())
//    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }
}
