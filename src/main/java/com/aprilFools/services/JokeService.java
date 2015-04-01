package com.aprilFools.services;

import com.aprilFools.models.Joke;

import java.util.List;

/**
 * Created by pivotal on 4/1/15.
 */
public interface JokeService {

    void insertJoke(Joke joke);
    Joke getJoke(String id);
    void updateJoke(Joke joke);
    void deleteJoke(String id);
    List<Joke> getAll();
}
