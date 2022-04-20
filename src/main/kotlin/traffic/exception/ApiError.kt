package traffic.exception

data class ApiError(
    val errorCode: String,
    val message: String,
)