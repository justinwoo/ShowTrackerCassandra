package com.github.kimagure.showtrackerdw.astyanax;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 * Created with IntelliJ IDEA.
 * User: jwoo
 * Date: 2/17/14
 * Time: 10:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class CassandraClient {
    private Cluster cluster;
    private Session session;

    public void start() {
        cluster = Cluster.builder()
                .addContactPoint("localhost")
                .build();
        session = cluster.connect("showtracker");
    }

    public void stop() {
    }

    public Session getSession() {
        return session;
    }

}
