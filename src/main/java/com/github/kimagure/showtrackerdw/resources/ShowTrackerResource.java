package com.github.kimagure.showtrackerdw.resources;

import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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

    public ShowTrackerResource() {
    }

    @GET
    @Path("/hello")
    @Timed
    public String sayHello() {
        return "Greetings, man-child.";
    }

//    @GET
//    @Timed
//    @Path("/shows")
//    public List<Show> getAllShows() {
//        return showDAO.findAll();
//    }
//
//    @GET
//    @Timed
//    @Path("/shows/title/{title}")
//    public Response getShow(@PathParam("title") String title) {
//        List<Show> shows = showDAO.findByTitle(title);
//        if (shows.size() > 0) {
//            return Response.ok(shows.get(0)).build();
//        } else {
//            String nastyMessage = "We ain't got no shows with that name. Get outta here!";
//            return Response.status(Response.Status.NOT_FOUND).entity(nastyMessage).build();
//        }
//    }
//
//    @GET
//    @Timed
//    @Path("/shows/{id}")
//    public Show getShow(@PathParam("id") LongParam id) {
//        return showDAO.findById(id.get());
//    }
//
//    @PUT
//    @Timed
//    @Path("/shows")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response putShow(Show show) {
//        Show prevShow = showDAO.findById(show.getId());
//        if (prevShow != null) {
//            prevShow.setTitle(show.getTitle());
//            prevShow.setEpisode(show.getEpisode());
//            show = showDAO.put(prevShow);
//            return Response.ok(prevShow).entity(show).build();
//        } else {
//            String nastyMessage = "What are you even trying to do here? Scram!";
//            return Response.status(Response.Status.BAD_REQUEST).entity(nastyMessage).build();
//        }
//    }
//
//    @POST
//    @Timed
//    @Path("/shows")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response postShow(Show show) {
//        if (showDAO.findByTitle(show.getTitle()).size() < 1) {
//            Long id = showDAO.post(show);
//            String friendlyMessage = "Yer show's been made with the id: " + id;
//            return Response.ok(show).entity(friendlyMessage).build();
//        } else {
//            String nastyMessage = "That show's already in the database, bozo";
//            return Response.status(Response.Status.BAD_REQUEST).entity(nastyMessage).build();
//        }
//    }

}
