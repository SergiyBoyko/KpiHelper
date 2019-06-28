package ua.devserhii.kpihelper.global.logic

import android.os.Looper
import android.util.Log
import kotlinx.coroutines.*
import org.koin.core.KoinComponent


open class UseCase<T> : KoinComponent {


    private fun execute(task: Deferred<T>, callback: (T) -> Unit) {
        CoroutineScope(Dispatchers.Default).launch {
            Log.d("MAIN_THREAD", (Looper.getMainLooper().thread == Thread.currentThread()).toString())
            try {
                val result = task.await() ?: return@launch
                callback.invoke(result)
            } catch (e: Exception) {
//                Log.e("Errors", e.localizedMessage)
                e.printStackTrace()
                pushError(e)
            }
        }
    }

    private fun execute(firstTask: Deferred<T>, secondTask: Deferred<T>, callback: (T, T) -> Unit) {
        CoroutineScope(Dispatchers.Default).launch {
            Log.d("MAIN_THREAD", (Looper.getMainLooper().thread == Thread.currentThread()).toString())
            try {
                val firstResult = firstTask.await() ?: return@launch
                val secondResult = secondTask.await() ?: return@launch
                callback.invoke(firstResult, secondResult)
            } catch (e: Exception) {
                Log.e("Errors", e.localizedMessage)
                pushError(e)
            }
        }
    }

    private fun execute(
        firstTask: Deferred<T>,
        secondTask: Deferred<T>,
        thirdTask: Deferred<T>,
        callback: (T, T, T) -> Unit
    ) {
        CoroutineScope(Dispatchers.Default).launch {
            Log.d("MAIN_THREAD", (Looper.getMainLooper().thread == Thread.currentThread()).toString())
            try {
                val firstResult = firstTask.await() ?: return@launch
                val secondResult = secondTask.await() ?: return@launch
                val thirdResult = thirdTask.await() ?: return@launch
                callback.invoke(firstResult, secondResult, thirdResult)
            } catch (e: Exception) {
                Log.e("Errors", e.localizedMessage)
                pushError(e)
            }
        }
    }

    fun execute(task: suspend () -> T, callback: (T) -> Unit) {
        execute(CoroutineScope(Dispatchers.Default).async { task.invoke() }, callback)
    }

    fun execute(firstTask: suspend () -> T, secondTask: suspend () -> T, callback: (T, T) -> Unit) {
        execute(
            CoroutineScope(Dispatchers.Default).async { firstTask.invoke() },
            CoroutineScope(Dispatchers.Default).async { secondTask.invoke() },
            callback
        )
    }

    fun execute(
        firstTask: suspend () -> T,
        secondTask: suspend () -> T,
        thirdTask: suspend () -> T,
        callback: (T, T, T) -> Unit
    ) {
        execute(
            CoroutineScope(Dispatchers.Default).async { firstTask.invoke() },
            CoroutineScope(Dispatchers.Default).async { secondTask.invoke() },
            CoroutineScope(Dispatchers.Default).async { thirdTask.invoke() },
            callback
        )
    }

    private fun pushError(e: Exception) {

    }
}
