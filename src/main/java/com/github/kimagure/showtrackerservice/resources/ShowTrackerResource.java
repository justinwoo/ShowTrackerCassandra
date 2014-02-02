package com.github.kimagure.showtrackerservice.resources;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    private final String template;
    private final String defaultName;

    public ShowTrackerResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
    }

    @GET
    @Timed
    public String sayHello(@QueryParam("name") Optional<String> name) {
        return String.format(template, name.or(defaultName));
    }
}
