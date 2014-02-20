package com.github.kimagure.showtrackerdw.cassandra;

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
    private String host;
    private String keyspace;

    public CassandraClient(String host, String keyspace) {
        this.host = host;
        this.keyspace = keyspace;
    }

    public void start() {
        cluster = Cluster.builder()
                .addContactPoint(host)
                .build();
        session = cluster.connect(keyspace);
    }

    public void stop() {
        session.shutdown();
        cluster.shutdown();
    }

    public Session getSession() {
        return session;
    }

}
