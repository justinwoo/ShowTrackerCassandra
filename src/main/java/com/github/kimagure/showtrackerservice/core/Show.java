package com.github.kimagure.showtrackerservice.core;

import org.hibernate.annotations.GenericGenerator;

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
                name = "com.github.kimagure.showtrackerservice.core.Show.findAll",
                query = "SELECT s FROM Show s"
        ),
        @NamedQuery(
                name = "com.github.kimagure.showtrackerservice.core.Show.findById",
                query = "SELECT s FROM Show s WHERE s.id = :id"
        ),
        @NamedQuery(
                name = "com.github.kimagure.showtrackerservice.core.Show.findByTitle",
                query = "SELECT s FROM Show s WHERE s.title = :title"
        )
})
public class Show {
    //    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "episode", nullable = false)
    private long episode = 1L;

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
