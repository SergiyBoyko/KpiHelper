package ua.devserhii.kpihelper

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ua.devserhii.kpihelper.di.*

/**
 * Created by Serhii Boiko on 23.06.2019.
 */
class KpiApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KpiApp)
            modules(listOf(apiModule, databaseModule, presenterModule, dataModule, logicModule))
        }
    }
}