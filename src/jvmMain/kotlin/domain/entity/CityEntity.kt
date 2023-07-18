package domain.entity

data class CityEntity(
    val name: String,
    val timezone: Int,
    val sunrise: Long,
    val sunset: Long
)
