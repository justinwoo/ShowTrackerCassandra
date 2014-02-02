package com.github.kimagure.showtrackerservice.core;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/1/14
 * Time: 9:57 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
public class Show {
    private final long id;
    private final String title;
    private final long episode;

    public Show(long id, String title, long episode) {
        this.id = id;
        this.title = title;
        this.episode = episode;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getEpisode() {
        return episode;
    }
}
