package data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
data class CityDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("coord")
    val coordinates: CoordinatesDto? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("population")
    val population: Int? = null,
    @SerializedName("timezone")
    val timezone: Int? = null,
    @SerializedName("sunrise")
    val sunrise: Long? = null,
    @SerializedName("sunset")
    val sunset: Long? = null
)
