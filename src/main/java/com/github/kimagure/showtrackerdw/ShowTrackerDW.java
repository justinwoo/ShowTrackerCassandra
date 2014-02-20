package com.github.kimagure.showtrackerdw;

import com.github.kimagure.showtrackerdw.DAO.ShowDAO;
import com.github.kimagure.showtrackerdw.cassandra.CassandraClient;
import com.github.kimagure.showtrackerdw.resources.ShowTrackerResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
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
public class ShowTrackerDW extends Service<ShowTrackerConfiguration> {
    public static void main(String[] args) throws Exception {
        new ShowTrackerDW().run(args);
    }

    @Override
    public void initialize(Bootstrap<ShowTrackerConfiguration> bootstrap) {
        bootstrap.setName("show-tracker");
        bootstrap.addBundle(new AssetsBundle("/assets", "/"));
    }

    @Override
    public void run(ShowTrackerConfiguration configuration, Environment environment) throws Exception {
        CassandraClient client = new CassandraClient("localhost", "showtracker");
        CassandraClientManager manager = new CassandraClientManager(client);
        manager.start();
        ShowDAO showDAO = new ShowDAO(manager.getSession());
        environment.addResource(new ShowTrackerResource(showDAO));
    }
}
