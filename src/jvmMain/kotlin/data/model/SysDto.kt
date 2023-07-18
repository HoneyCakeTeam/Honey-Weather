package data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class SysDto(
    @SerializedName("pod")
    val pod: String? = null
)
