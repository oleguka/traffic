package traffic.service

import org.springframework.stereotype.Service
import traffic.dto.TrafficDto
import traffic.model.Traffic
import traffic.repository.TrafficRepository

@Service
class TrafficServiceImpl(
    private val trafficRepository: TrafficRepository,
) : TrafficService {
    override fun getAll(): List<TrafficDto> = trafficRepository.getAll()
        .map { it.toDto() }

    override fun getById(id: Int): TrafficDto =
        trafficRepository.findById(id)
            ?.toDto()
            ?: throw RuntimeException("Traffic with id = $id not found")

    override fun create(dto: TrafficDto) {
        TODO("Not yet implemented")
    }

    override fun update(id: Int, dto: TrafficDto) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    private fun Traffic.toDto() = TrafficDto(
        id = id,
        title = title,
        passengerCount = passengerCount,
    )

}