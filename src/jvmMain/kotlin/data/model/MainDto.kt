package data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class MainDto(
    @SerializedName("temp")
    val temp: Double? = null,
    @SerializedName("feels_like")
    val feels_like: Double? = null,
    @SerializedName("temp_min")
    val temp_min: Double? = null,
    @SerializedName("temp_max")
    val temp_max: Double? = null,
    @SerializedName("pressure")
    val pressure: Int? = null,
    @SerializedName("sea_level")
    val sea_level: Int? = null,
    @SerializedName("grnd_level")
    val grnd_level: Int? = null,
    @SerializedName("humidity")
    val humidity: Int? = null,
    @SerializedName("temp_kf")
    val temp_kf: Double? = null
)
