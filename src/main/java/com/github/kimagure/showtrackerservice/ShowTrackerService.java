package com.github.kimagure.showtrackerservice;

import com.github.kimagure.showtrackerservice.health.TemplateHealthCheck;
import com.github.kimagure.showtrackerservice.resources.ShowTrackerResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/1/14
 * Time: 9:46 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
public class ShowTrackerService extends Service<ShowTrackerConfiguration> {
    public static void main(String[] args) throws Exception {
        new ShowTrackerService().run(args);
    }

    @Override
    public void initialize(Bootstrap<ShowTrackerConfiguration> bootstrap) {
        bootstrap.setName("show-tracker");
    }

    @Override
    public void run(ShowTrackerConfiguration configuration, Environment environment) {
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.addResource(new ShowTrackerResource(template, defaultName));
        environment.addHealthCheck(new TemplateHealthCheck(template));
    }
}
