package domain.usecase

import data.repository.WeatherRepo
import domain.entity.WeatherEntity
import util.filterWeatherItems
import util.getForecastDate
import java.time.LocalDate

class GetTodayWeatherItemsUseCase(private val repo: WeatherRepo) {
    suspend operator fun invoke(lat: String, lon: String): WeatherEntity {
        val forecastData = repo.fetchData(lat, lon)
        val filteredItems = forecastData.filterWeatherItems { forecastItem ->
            val forecastDate = forecastItem.getForecastDate()
            forecastDate == LocalDate.now()
        }
        return forecastData.copy(forecastItems = filteredItems)
    }
}
