package traffic.controller

import org.springframework.context.ApplicationEventPublisher
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import traffic.dto.TrafficDto
import traffic.event.TrafficEvent
import traffic.service.TrafficService

@RestController
@RequestMapping("/traffic")
class TrafficController(
    private val trafficService: TrafficService,
    val publisher: ApplicationEventPublisher,
) {

    @GetMapping
    fun getAll(): List<TrafficDto> = trafficService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): TrafficDto = trafficService.getById(id)

    @PostMapping
    fun create(@RequestBody dto: TrafficDto): Int {

        val id = trafficService.create(dto)

        val event = TrafficEvent(
            sourceObject = this,
            payload = "Create traffic"
        )
        publisher.publishEvent(event)

        return id
    }


    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody dto: TrafficDto) {
        trafficService.update(id, dto)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Int) {
        trafficService.deleteById(id)
    }

}