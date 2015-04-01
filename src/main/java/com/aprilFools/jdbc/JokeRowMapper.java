package com.aprilFools.jdbc;

import com.aprilFools.models.Joke;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by pivotal on 4/1/15.
 */
public class JokeRowMapper implements RowMapper {

    @Override
    public Joke mapRow(ResultSet resultSet, int line) throws SQLException {
        JokeExtractor jokeExtractor = new JokeExtractor();
        return jokeExtractor.extractData(resultSet);
    }
}
