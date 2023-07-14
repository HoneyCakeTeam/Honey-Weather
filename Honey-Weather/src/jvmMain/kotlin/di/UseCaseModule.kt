package di
import domain.usecase.GetRemainWeatherItemsUseCase
import domain.usecase.GetTodayWeatherItemsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetTodayWeatherItemsUseCase(get()) }
    single { GetRemainWeatherItemsUseCase(get()) }
}
