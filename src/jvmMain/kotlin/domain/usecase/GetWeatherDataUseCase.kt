package domain.usecase

import data.repository.WeatherRepo
import domain.entity.WeatherData
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GetWeatherDataUseCase(private val repo: WeatherRepo) {

    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    suspend operator fun invoke(lat: String, lon: String): WeatherData {
        val forecastData = repo.fetchData(lat, lon)
        val todayWeather = forecastData.forecastItems.filter {
            val forecastDateTime = LocalDateTime.parse(it.dateTime, formatter)
            forecastDateTime.toLocalDate() == LocalDate.now()
        }
        val remainWeather = forecastData.forecastItems.filter {
            val forecastDateTime = LocalDateTime.parse(it.dateTime, formatter)
            forecastDateTime.toLocalDate() != LocalDate.now()
        }
        return WeatherData(
            forecastData.copy(forecastItems = todayWeather),
            forecastData.copy(forecastItems = remainWeather)
        )
    }
}
