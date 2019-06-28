package ua.devserhii.kpihelper.di

import org.koin.dsl.module
import ua.devserhii.kpihelper.pages.start.logic.SearchGroupUseCase
import ua.devserhii.kpihelper.pages.start.persistance.SearchGroupDataSource
import ua.devserhii.kpihelper.pages.start.persistance.remote.SearchGroupRemoteDataSource
import ua.devserhii.kpihelper.pages.start.presentation.SearchGroupPresenter
import ua.devserhii.kpihelper.persistance.ServiceGenerator
import ua.devserhii.kpihelper.persistance.api.KpiApi

/**
 * Created by Serhii Boiko on 23.06.2019.
 */
val apiModule = module {
    single { ServiceGenerator().createService(KpiApi::class.java) }
}

val presenterModule = module {
    factory { SearchGroupPresenter(get()) }
}

val dataModule = module {
    single<SearchGroupDataSource> { SearchGroupRemoteDataSource(get()) }
}

val logicModule = module {
    single { SearchGroupUseCase(get()) }
}