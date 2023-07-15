package data.model

import kotlinx.serialization.Serializable

@Serializable
data class ForecastItemDto(
    val dt: Long,
    val main: MainDto,
    val weather: List<Weather>,
    val clouds: CloudsDto,
    val wind: WindDto,
    val visibility: Int,
    val pop: Double,
    val sys: SysDto,
    val dt_txt: String
)
