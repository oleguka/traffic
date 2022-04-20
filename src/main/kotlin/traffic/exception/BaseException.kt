package traffic.exception

import org.springframework.http.HttpStatus

abstract class BaseException(
    val errorCode: String,
    override val message: String,
    val status: HttpStatus,
) :
    RuntimeException(message)

class TrafficNotFoundException(id: Int) : BaseException(
    errorCode = "traffic.not.found",
    message = "Traffic with id = $id not found",
    status = HttpStatus.NOT_FOUND,
)