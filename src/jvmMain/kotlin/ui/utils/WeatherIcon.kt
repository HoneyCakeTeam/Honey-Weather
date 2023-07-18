package ui.utils


fun getWeatherIconResource(icon: String): String {
    return when (icon) {
        "01d" -> "image/01d.png"
        "01n" -> "image/01n.png"
        "02d" -> "image/02d.png"
        "02n" -> "image/02n.png"
        "03d" -> "image/03d.png"
        "03n" -> "image/03n.png"
        "04d" -> "image/04d.png"
        "04n" -> "image/04n.png"
        "09d" -> "image/09d.png"
        "09n" -> "image/09n.png"
        "10d" -> "image/10d.png"
        "10n" -> "image/10n.png"
        "11d" -> "image/11d.png"
        "11n" -> "image/11n.png"
        "13d" -> "image/13d.png"
        "13n" -> "image/13n.png"
        "50d" -> "image/50d.png"
        "50n" -> "image/50n.png"
        else -> "image/smiling_face.png.png"
    }
}
