package traffic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class TrafficApplication

fun main(args: Array<String>) {
    runApplication<TrafficApplication>(*args)
}