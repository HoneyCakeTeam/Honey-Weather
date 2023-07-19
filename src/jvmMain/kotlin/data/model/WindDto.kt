package data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class WindDto(
    @SerializedName("speed")
    val speed: Double? = null,
    @SerializedName("deg")
    val degree: Int? = null,
    @SerializedName("gust")
    val gust: Double? = null
)
