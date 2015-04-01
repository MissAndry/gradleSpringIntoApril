package com.aprilFools.services;

import com.aprilFools.daos.JokeDAO;
import com.aprilFools.models.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pivotal on 4/1/15.
 */
@Service
public class JokeServiceImplementation implements JokeService {

    @Autowired
    JokeDAO jokeDAO;

    @Override
    public void insertJoke(Joke joke) {
        jokeDAO.createJoke(joke);
    }

    @Override
    public Joke getJoke(String id) {
        return jokeDAO.getJoke(id);
    }

    @Override
    public void updateJoke(Joke joke) {
        jokeDAO.updateJoke(joke);
    }

    @Override
    public void deleteJoke(String id) {
        jokeDAO.deleteJoke(id);
    }

    @Override
    public List<Joke> getAll() {
        return jokeDAO.getAll();
    }
}
