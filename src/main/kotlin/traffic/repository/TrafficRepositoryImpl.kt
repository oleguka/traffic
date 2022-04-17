package traffic.repository

import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
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

    override fun create(dto: Traffic) {
        TODO("Not yet implemented")
    }

    override fun update(id: Int, dto: Traffic) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
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