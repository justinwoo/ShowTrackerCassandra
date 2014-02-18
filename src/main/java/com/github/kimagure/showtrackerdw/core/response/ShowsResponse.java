package com.github.kimagure.showtrackerdw.core.response;

import com.github.kimagure.showtrackerdw.core.models.Show;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jwoo
 * Date: 2/17/14
 * Time: 9:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowsResponse {
    private final List<Show> shows;

    public ShowsResponse(List<Show> shows) {
        this.shows = shows;
    }

    public List<Show> getShows() {
        return shows;
    }
}
