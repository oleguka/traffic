package traffic.schedule

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import traffic.service.TrafficService

@Component
class TrafficScheduler(
    private val service: TrafficService
) {

    @Scheduled(cron = "\${scheduler.traffic.deleteAll}")
    fun deleteAllTraffic() {
        service.deleteAll()
    }
}