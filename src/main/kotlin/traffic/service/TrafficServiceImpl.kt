package traffic.service

import org.springframework.stereotype.Service
import traffic.dto.TrafficDto
import traffic.exception.TrafficNotFoundException
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
            ?: throw TrafficNotFoundException(id)

    override fun create(dto: TrafficDto): Int =
        trafficRepository.create(dto)

    override fun update(id: Int, dto: TrafficDto) {
        trafficRepository.update(id, dto)
    }

    override fun deleteById(id: Int) {
        trafficRepository.deleteById(id)
    }

    private fun Traffic.toDto() = TrafficDto(
        id = id,
        title = title,
        passengerCount = passengerCount,
    )

}