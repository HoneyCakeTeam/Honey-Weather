package di

import data.repository.WeatherRepoImpl
import data.repository.WeatherRepo
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repoModule = module {
    singleOf(::WeatherRepoImpl) { bind<WeatherRepo>() }
}