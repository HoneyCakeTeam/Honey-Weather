package domain.usecase

import data.model.WeatherDto
import data.repository.WeatherRepo
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GetRemainWeatherItemsUseCase(private val repo: WeatherRepo) {
    suspend operator fun invoke(lat: String, lon: String): WeatherDto {
        val forecastData = repo.fetchData(lat, lon)
        val today = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val filteredItems = forecastData.list.filterNot { forecastItem ->
            val forecastDateTime = LocalDateTime.parse(forecastItem.dt_txt, formatter)
            val forecastDate = forecastDateTime.toLocalDate()
            forecastDate == today
        }
        return forecastData.copy(list = filteredItems)
    }
}