package com.aprilFools.models;

/**
 * Created by pivotal on 4/1/15.
 */
public class Joke {

    private long id;
    private String setup;
    private String punchline;
    private static final String template = "Q: %s?\nA: %s!";

    public Joke() {
    }

    public long getId() {
        return id;
    }

    public String getSetup() {
        return setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

    @Override
    public String toString() {
        return String.format(template, setup, punchline);
    }
}
