package traffic.repository

import org.springframework.web.bind.annotation.RequestBody
import traffic.model.Traffic

interface TrafficRepository {

    fun getAll(): List<Traffic>

    fun findById(id: Int): Traffic?

    fun create(dto: Traffic)

    fun update(id: Int, @RequestBody dto: Traffic)

    fun delete(id: Int)

}