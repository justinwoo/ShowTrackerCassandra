package com.github.kimagure.showtrackerservice;

import com.github.kimagure.showtrackerservice.core.Show;
import com.github.kimagure.showtrackerservice.health.TemplateHealthCheck;
import com.github.kimagure.showtrackerservice.hibernate.ShowDAO;
import com.github.kimagure.showtrackerservice.resources.ShowTrackerResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.hibernate.HibernateBundle;

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

    private final HibernateBundle<ShowTrackerConfiguration> hibernate = new HibernateBundle<ShowTrackerConfiguration>(Show.class) {
        @Override
        public DatabaseConfiguration getDatabaseConfiguration(ShowTrackerConfiguration configuration) {
            return configuration.getDatabaseConfiguration();
        }
    };

    @Override
    public void initialize(Bootstrap<ShowTrackerConfiguration> bootstrap) {
        bootstrap.setName("show-tracker");
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(ShowTrackerConfiguration configuration, Environment environment) {
        final ShowDAO showDAO = new ShowDAO(hibernate.getSessionFactory());
        environment.addResource(new ShowTrackerResource(showDAO));
    }
}
