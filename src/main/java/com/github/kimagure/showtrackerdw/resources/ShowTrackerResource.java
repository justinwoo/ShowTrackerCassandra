package com.github.kimagure.showtrackerdw.resources;

import com.github.kimagure.showtrackerdw.DAO.ShowDAO;
import com.github.kimagure.showtrackerdw.core.models.Show;
import com.github.kimagure.showtrackerdw.core.response.ShowResponse;
import com.github.kimagure.showtrackerdw.core.response.ShowsResponse;
import com.yammer.dropwizard.jersey.params.LongParam;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
@Path("/show-tracker")
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
    public ShowsResponse getAllShows() {
        List<Show> shows = showDAO.findAll();
        return new ShowsResponse(shows);
    }

    @GET
    @Timed
    @Path("/shows/title/{title}")
    public ShowResponse getShowByTitle(@PathParam("title") String title) {
        List<Show> shows = showDAO.findByTitle(title);
        if (shows.size() > 0) {
            return new ShowResponse(shows.get(0));
        } else {
            String nastyMessage = "We ain't got no shows with that name. Get outta here!";
            Response response = Response.status(Response.Status.NOT_FOUND).entity(nastyMessage).build();
            throw new WebApplicationException(response);
        }
    }

    @GET
    @Timed
    @Path("/shows/{id}")
    public ShowResponse getShowById(@PathParam("id") String id) {
        Show show = showDAO.findById(id);
        return new ShowResponse(show);
    }

    @PUT
    @Timed
    @Path("/shows/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public ShowResponse putShow(@PathParam("id") String id, Show show) {
        return persistShow(id, show);
    }

    @POST
    @Timed
    @Path("/shows")
    @Consumes(MediaType.APPLICATION_JSON)
    public ShowResponse postShow(Show show) {
        String uuid = UUID.randomUUID().toString();
        return persistShow(uuid, show);
    }

    private ShowResponse persistShow(String id, Show show) {
        Show persistShow = new Show(id, show.getTitle(), show.getEpisode());
        showDAO.persist(persistShow);
        return new ShowResponse(persistShow);
    }
}
