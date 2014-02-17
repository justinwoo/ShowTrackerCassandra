package com.github.kimagure.showtrackerdw.core;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/1/14
 * Time: 9:57 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
public class Show {
    private final String id;
    private String title;
    private final long episode;

    public Show(String id, long episode, String title) {
        this.id = id;
        this.episode = episode;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getEpisode() {
        return episode;
    }
}
