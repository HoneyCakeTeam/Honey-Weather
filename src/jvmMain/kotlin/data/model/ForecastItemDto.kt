package data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastItemDto(
    @SerializedName("dt")
    val dt: Long? = null,
    @SerializedName("main")
    val main: MainDto? = null,
    @SerializedName("weather")
    val weather: List<Weather>? = null,
    @SerializedName("clouds")
    val clouds: CloudsDto? = null,
    @SerializedName("wind")
    val wind: WindDto? = null,
    @SerializedName("visibility")
    val visibility: Int? = null,
    @SerializedName("pop")
    val pop: Double? = null,
    @SerializedName("sys")
    val sys: SysDto? = null,
    @SerializedName("dt_txt")
    val dt_txt: String? = null
)
