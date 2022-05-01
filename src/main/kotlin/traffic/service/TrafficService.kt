package traffic.service

import org.springframework.web.bind.annotation.RequestBody
import traffic.dto.TrafficDto

interface TrafficService {

    fun getAll(): List<TrafficDto>

    fun getById(id: Int): TrafficDto

    fun create(dto: TrafficDto): Int

    fun update(id: Int, @RequestBody dto: TrafficDto)

    fun deleteById(id: Int)

    fun deleteAll()

}