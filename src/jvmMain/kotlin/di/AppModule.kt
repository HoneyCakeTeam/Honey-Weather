package di

import org.koin.dsl.module
import ui.viewmodel.WeatherViewModel

val appModules = module {
    single { WeatherViewModel() }
    includes(repoModule, useCaseModule, networkModule)
}