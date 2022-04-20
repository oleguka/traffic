package traffic.repository

import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository
import traffic.dto.TrafficDto
import traffic.model.Traffic
import traffic.utils.getIntOrNull

@Repository
class TrafficRepositoryImpl(
    private val jdbcTemplate: NamedParameterJdbcTemplate,
) : TrafficRepository {

    override fun getAll(): List<Traffic> =
        jdbcTemplate.query(
            "select * from traffic order by title",
            ROW_MAPPER
        )

    override fun findById(id: Int): Traffic? =
        jdbcTemplate.query(
            "select * from traffic where id = :id",
            mapOf("id" to id),
            ROW_MAPPER
        ).firstOrNull()

    override fun create(dto: TrafficDto): Int {
        val keyHolder = GeneratedKeyHolder()
        jdbcTemplate.update(
            "insert into traffic (title, passenger_count) values (:title, :passengerCount)",
            MapSqlParameterSource(
                mapOf(
                    "title" to dto.title,
                    "passengerCount" to dto.passengerCount,
                )
            ),
            keyHolder,
            listOf("id").toTypedArray()
        )
        return keyHolder.keys?.getValue("id") as Int
    }

    override fun update(id: Int, dto: TrafficDto) {
        jdbcTemplate.update(
            "update traffic set title = :title, passenger_count = :passengerCount where id = :id",
            mapOf(
                "id" to id,
                "title" to dto.title,
                "passengerCount" to dto.passengerCount,
            )
        )
    }

    override fun deleteById(id: Int) {
        jdbcTemplate.update(
            "delete from traffic where id = :id",
            mapOf("id" to id)
        )
    }

    private companion object {
        val ROW_MAPPER = RowMapper<Traffic> { rs, _ ->
            Traffic(
                id = rs.getInt("id"),
                title = rs.getString("title"),
                passengerCount = rs.getIntOrNull("passenger_count"),
            )
        }
    }

}