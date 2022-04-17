package traffic.dto

data class TrafficDto(
    val id: Int = 0,
    val title: String,
    val passengerCount: Int? = null,
)