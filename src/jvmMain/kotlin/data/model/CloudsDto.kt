package data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CloudsDto(
    @SerializedName("all")
    val all: Int? = null
)
