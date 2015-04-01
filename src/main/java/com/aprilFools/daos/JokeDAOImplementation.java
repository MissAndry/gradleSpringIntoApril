package com.aprilFools.daos;


import com.aprilFools.jdbc.JokeRowMapper;
import com.aprilFools.models.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by pivotal on 4/1/15.
 */
@Service
public class JokeDAOImplementation implements JokeDAO {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    @Override
    public void createJoke(Joke joke) {
        String SQL = "INSERT INTO jokes (id, setup, punchline) VALUES (?, ?, ?)";
        jdbcTemplate.update(SQL, new Object[]{
                joke.getId(),
                joke.getSetup(),
                joke.getPunchline(),
        });
    }

    @Override
    public Joke getJoke(String id) {
        String SQL = "SELECT * FROM jokes WHERE id=" + id;
        List<Joke>jokeList = jdbcTemplate.query(SQL, new JokeRowMapper());
        return jokeList.get(0);
    }

    @Override
    public void updateJoke(Joke joke) {
        String SQL = "UPDATE jokes SET setup = ?, punchline = ? WHERE id = ?";
        jdbcTemplate.update(SQL, new Object[]{
                joke.getSetup(),
                joke.getPunchline(),
                joke.getId(),
        });
    }

    @Override
    public void deleteJoke(String id) {
        String SQL = "DELETE FROM jokes WHERE id =" + id;
        jdbcTemplate.update(SQL);
    }

    @Override
    public List<Joke> getAll() {
        String SQL = "SELECT * FROM jokes";
        return jdbcTemplate.query(SQL, new JokeRowMapper());
    }
}
