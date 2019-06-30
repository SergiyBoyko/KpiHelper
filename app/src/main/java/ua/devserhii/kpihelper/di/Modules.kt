package ua.devserhii.kpihelper.di

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import ua.devserhii.kpihelper.pages.main.dashboard.presentation.DashboardPresenter
import ua.devserhii.kpihelper.pages.main.prefs.logic.ExitUseCase
import ua.devserhii.kpihelper.pages.main.prefs.presentation.PrefsPresenter
import ua.devserhii.kpihelper.pages.main.timetable.logic.GetCurrentTimetableUseCase
import ua.devserhii.kpihelper.pages.main.timetable.persistance.TimetableDataSource
import ua.devserhii.kpihelper.pages.main.timetable.persistance.remote.TimetableRemoteDataSource
import ua.devserhii.kpihelper.pages.main.timetable.presentation.TimetablePresenter
import ua.devserhii.kpihelper.pages.start.logic.DownloadTimetableUseCase
import ua.devserhii.kpihelper.pages.start.logic.SearchGroupUseCase
import ua.devserhii.kpihelper.pages.start.persistance.SearchGroupDataSource
import ua.devserhii.kpihelper.pages.start.persistance.remote.SearchGroupRemoteDataSource
import ua.devserhii.kpihelper.pages.start.presentation.SearchGroupPresenter
import ua.devserhii.kpihelper.persistance.api.KpiApi
import ua.devserhii.kpihelper.persistance.api.ServiceGenerator
import ua.devserhii.kpihelper.persistance.database.AppDatabase

/**
 * Created by Serhii Boiko on 23.06.2019.
 */
val apiModule = module {
    single { ServiceGenerator().createService(KpiApi::class.java) }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "db")
                .fallbackToDestructiveMigration()
                .build()
    }
}

val presenterModule = module {
    factory { SearchGroupPresenter(get(), get()) }
    factory { TimetablePresenter(get()) }
    factory { PrefsPresenter(get()) }
    factory { DashboardPresenter(get()) }
}

val dataModule = module {
    single<SearchGroupDataSource> { SearchGroupRemoteDataSource(get()) }
    single<TimetableDataSource> { TimetableRemoteDataSource(get(), get()) }
}

val logicModule = module {
    single { SearchGroupUseCase(get()) }
    single { DownloadTimetableUseCase(get()) }
    single { GetCurrentTimetableUseCase(get()) }
    single { ExitUseCase(get()) }
}
