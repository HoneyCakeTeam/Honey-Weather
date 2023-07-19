package data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class MainDto(
    @SerializedName("temp")
    val temp: Double? = null,
    @SerializedName("feels_like")
    val feelsLike: Double? = null,
    @SerializedName("temp_min")
    val minimumTemp: Double? = null,
    @SerializedName("temp_max")
    val maximumTemp: Double? = null,
    @SerializedName("pressure")
    val pressure: Int? = null,
    @SerializedName("sea_level")
    val seaLevel: Int? = null,
    @SerializedName("grnd_level")
    val groundLlevel: Int? = null,
    @SerializedName("humidity")
    val humidity: Int? = null,
    @SerializedName("temp_kf")
    val temp_kf: Double? = null
)
