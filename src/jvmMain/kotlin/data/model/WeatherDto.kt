package data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    @SerializedName("cod")
    val cod: String? = null,
    @SerializedName("message")
    val message: Int? = null,
    @SerializedName("cnt")
    val cnt: Int? = null,
    @SerializedName("list")
    val list: List<ForecastItemDto>? = null,
    @SerializedName("city")
    val city: CityDto? = null
)
