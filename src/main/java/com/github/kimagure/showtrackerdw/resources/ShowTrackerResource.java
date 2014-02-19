package com.github.kimagure.showtrackerdw.resources;

import com.github.kimagure.showtrackerdw.DAO.ShowDAO;
import com.github.kimagure.showtrackerdw.core.models.Show;
import com.github.kimagure.showtrackerdw.core.response.ShowPayload;
import com.github.kimagure.showtrackerdw.core.response.ShowsPayload;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/2/14
 * Time: 2:48 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class ShowTrackerResource {

    private ShowDAO showDAO;

    public ShowTrackerResource(ShowDAO showDAO) {
        this.showDAO = showDAO;
    }

    @GET
    @Path("/hello")
    @Timed
    public String sayHello() {
        return "Greetings, man-child.";
    }

    @GET
    @Timed
    @Path("/shows")
    public ShowsPayload getAllShows() {
        List<Show> shows = showDAO.findAll();
        return new ShowsPayload(shows);
    }

    @GET
    @Timed
    @Path("/shows/title/{title}")
    public ShowPayload getShowByTitle(@PathParam("title") String title) {
        Show show = showDAO.findByTitle(title);
        return new ShowPayload(show);
    }

    @GET
    @Timed
    @Path("/shows/{id}")
    public ShowPayload getShowById(@PathParam("id") String id) {
        Show show = showDAO.findById(id);
        return new ShowPayload(show);
    }

    @PUT
    @Timed
    @Path("/shows/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public ShowPayload putShow(@PathParam("id") String id, ShowPayload showPayload) {
        return persistShow(id, showPayload.getShow());
    }

    @DELETE
    @Timed
    @Path("/shows/{id}")
    public void deleteShow(@PathParam("id") String id) {
        showDAO.delete(id);
    }

    @POST
    @Timed
    @Path("/shows")
    @Consumes(MediaType.APPLICATION_JSON)
    public ShowPayload postShow(ShowPayload showPayload) {
        String uuid = UUID.randomUUID().toString();
        return persistShow(uuid, showPayload.getShow());
    }

    private ShowPayload persistShow(String id, Show show) {
        Show persistShow = new Show(id, show.getTitle(), show.getEpisode());
        showDAO.persist(persistShow);
        return new ShowPayload(persistShow);
    }
}
