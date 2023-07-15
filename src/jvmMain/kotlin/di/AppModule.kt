package di

import data.repository.WeatherRepo
import data.repository.WeatherRepoImpl
import domain.usecase.GetRemainWeatherItemsUseCase
import domain.usecase.GetTodayWeatherItemsUseCase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ui.viewmodel.WeatherViewModel


val appModules = module {
    single { WeatherViewModel(get(),get()) }
    single { GetTodayWeatherItemsUseCase(get()) }
    single { GetRemainWeatherItemsUseCase(get()) }
    singleOf(::WeatherRepoImpl) { bind<WeatherRepo>() }
    includes(networkModule)
}