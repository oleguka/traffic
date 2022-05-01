package traffic.event

import org.springframework.context.ApplicationEvent

data class TrafficEvent(
    val sourceObject: Any,
    val payload: String
) : ApplicationEvent(sourceObject)