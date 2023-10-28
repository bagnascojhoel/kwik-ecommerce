package com.nocpah.kwik.rulesapi.common.query;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SqlQueryExecutor {
    private final JdbcTemplate jdbcTemplate;

    public <T> List<T> queryForList(String statement, Class<T> returnType) {
        return this.jdbcTemplate.query(statement, new BeanPropertyRowMapper<>(returnType));
    }
}
