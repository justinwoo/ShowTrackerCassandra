package com.github.kimagure.showtrackerservice.core;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/1/14
 * Time: 9:57 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
@Entity
@Table(name = "Shows")
@NamedQueries({
        @NamedQuery(
                name = "com.github.kimagure.core.Show.findAll",
                query = "SELECT s FROM Show s"
        ),
        @NamedQuery(
                name = "com.github.kimagure.core.Show.findById",
                query = "SELECT s FROM Show s WHERE s.id = :id"
        )
})
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "episode", nullable = false)
    private long episode;

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEpisode(long episode) {
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
