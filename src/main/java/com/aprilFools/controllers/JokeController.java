package com.aprilFools.controllers;

import com.aprilFools.models.Joke;
import com.aprilFools.services.JokeService;
import com.aprilFools.services.JokeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by pivotal on 4/1/15.
 */
@RestController
@RequestMapping("/jokes")
public class JokeController {

    @Autowired
    JokeServiceImplementation jokeService;

    @RequestMapping("/")
    public List<Joke> index(ModelMap model, HttpServletRequest request, HttpServletResponse response){
        List<Joke> jokeList = jokeService.getAll();
        return jokeList;
    }

    @RequestMapping("/new")
    public ModelAndView newJoke() {
        return new ModelAndView("new", "create", new Joke());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Model create(@ModelAttribute Joke joke, Model model){
        model.addAttribute("setup", joke.getSetup());
        model.addAttribute("punchline", joke.getPunchline());
        model.addAttribute("id", joke.getId());
        return model;
//        return "index";
    }

    @RequestMapping("/{id}")
    public Joke show(ModelMap model, HttpServletRequest request, HttpServletResponse response, @RequestParam String id) {
        return jokeService.getJoke(id);
//        return "show";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Joke update(@ModelAttribute Joke joke, ModelMap model, @RequestParam String id){
        Joke jokeToBeUpdated = jokeService.getJoke(id);

        model.replace("setup", jokeToBeUpdated.getSetup(), joke.getSetup());
        model.replace("punchline", jokeToBeUpdated.getPunchline(), joke.getPunchline());
        return joke;
//        return "show";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public List<Joke> delete(@RequestParam String id){
        jokeService.deleteJoke(id);
        return jokeService.getAll();
//        return "index";
    }
}
