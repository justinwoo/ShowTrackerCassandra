package com.github.kimagure.showtrackerdw.core.models;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/1/14
 * Time: 9:57 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
public class Show {
    private String id;
    private String title;
    private Integer episode;

    public Show() {
    }

    public Show(String id, String title, Integer episode) {
        this.id = id;
        this.title = title;
        this.episode = episode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }
}
