package br.com.bagnascojhoel.kwik_ecommerce.product.infrastructure.driven_ports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.TemporalUnitWithinOffset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.UUID;

<<<<<<< HEAD
@JdbcTest(properties = {
        "spring.datasource.hikari.jdbc-url=jdbc:tc:postgresql:9.6.8:///kwik_ecommerce?currentSchema=product",
=======
<<<<<<< HEAD
@JdbcTest(properties = {
        "spring.datasource.hikari.jdbc-url=jdbc:tc:postgresql:9.6.8:///kwik_ecommerce?currentSchema=product",
=======
<<<<<<< HEAD
@JdbcTest(properties = {
        "spring.datasource.hikari.jdbc-url=jdbc:tc:postgresql:9.6.8:///kwik_ecommerce?currentSchema=product",
=======
import static br.com.bagnascojhoel.kwik_ecommerce.common.infrastructure.CommonTestConstants.TEST_CONTAINER_POSTGRES_JDBC_URL;

@JdbcTest(properties = {
        "spring.datasource.hikari.jdbc-url=" + TEST_CONTAINER_POSTGRES_JDBC_URL + "?currentSchema=product",
>>>>>>> 6b0331d (feat(api): create products CRUD)
>>>>>>> 47b2bca (feat(api): create products CRUD)
>>>>>>> 1b40fd0 (feat(api): create products CRUD)
        "spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver"
})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public abstract class AbstractJdbcRepositoryTest {

    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    protected void assertModifiedFieldsAreFilled(
            final String table,
            final UUID id
    ) {
        namedParameterJdbcTemplate.queryForStream(
                "SELECT modified_at, modified_by FROM " + table + " WHERE id = :id",
                Map.of("id", id),
                (rs, rowNum) -> new AuditModified(rs.getString("modified_by"), rs.getTimestamp("modified_at").toLocalDateTime())
        ).forEach(result -> {
            Assertions.assertThat(result.getModifiedBy()).isNotBlank();
            Assertions.assertThat(result.getModifiedAt()).isCloseTo(LocalDateTime.now(), new TemporalUnitWithinOffset(1, ChronoUnit.MINUTES));
        });
    }

    @AllArgsConstructor
    @Getter
    private final class AuditModified {
        private final String modifiedBy;
        private final LocalDateTime modifiedAt;
    }
}
