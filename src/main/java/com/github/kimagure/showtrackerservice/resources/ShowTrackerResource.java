package com.github.kimagure.showtrackerservice.resources;

import com.github.kimagure.showtrackerservice.core.Show;
import com.github.kimagure.showtrackerservice.hibernate.ShowDAO;
import com.yammer.dropwizard.hibernate.UnitOfWork;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.yammer.dropwizard.jersey.params.*;

import java.util.List;

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
    @UnitOfWork
    @Path("/get/all")
    public List<Show> getAllShows() {
        return showDAO.findAll();
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/get/{id}")
    public Show getShow(@PathParam("id") LongParam id) {
        return showDAO.findById(id.get());
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/get-by-title/{title}")
    public Response getShow(@PathParam("title") String title) {
        List<Show> shows = showDAO.findByTitle(title);
        if (shows.size() > 0) {
            return Response.ok(shows.get(0)).build();
        } else {
            String nastyMessage = "We ain't got no shows with that name. Get outta here.";
            return Response.status(Response.Status.NOT_FOUND).entity(nastyMessage).build();
        }
    }

    @POST
    @Timed
    @UnitOfWork
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postShow(Show show) {
        if (showDAO.findByTitle(show.getTitle()).size() < 1) {
            Long id = showDAO.post(show);
            show.setId(id);
            return Response.ok(show).build();
        } else {
            String nastyMessage = "That show's already in the database, bozo";
            return Response.status(Response.Status.BAD_REQUEST).entity(nastyMessage).build();
        }
    }

}
