import data.model.WeatherDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class WeatherService(private val httpClient: HttpClient) {

    suspend fun getWeatherData(lat: String, lon: String): WeatherDto {
        return httpClient.get {
            parameter("lat", lat)
            parameter("lon", lon)
        }
    }
}