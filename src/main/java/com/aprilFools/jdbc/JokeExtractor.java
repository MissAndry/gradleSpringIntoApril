package com.aprilFools.jdbc;

import com.aprilFools.models.Joke;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.dao.DataAccessException;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by pivotal on 4/1/15.
 */
public class JokeExtractor implements ResultSetExtractor {

    public Joke extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Joke joke = new Joke();

        joke.setId(resultSet.getInt(1));
        joke.setSetup(resultSet.getString(2));
        joke.setPunchline(resultSet.getString(3));

        return joke;
    }
}
