package traffic.repository

import org.springframework.web.bind.annotation.RequestBody
import traffic.dto.TrafficDto
import traffic.model.Traffic

interface TrafficRepository {

    fun getAll(): List<Traffic>

    fun findById(id: Int): Traffic?

    fun create(dto: TrafficDto): Int

    fun update(id: Int, @RequestBody dto: TrafficDto)

    fun deleteById(id: Int)

}