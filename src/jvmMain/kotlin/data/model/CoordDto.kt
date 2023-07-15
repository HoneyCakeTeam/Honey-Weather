package data.model

import kotlinx.serialization.Serializable

@Serializable
data class CoordDto(
    val lat: Double,
    val lon: Double
)
