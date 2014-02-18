package com.github.kimagure.showtrackerdw;

import com.github.kimagure.showtrackerdw.astyanax.CassandraClient;
import com.yammer.dropwizard.lifecycle.Managed;

/**
 * Created with IntelliJ IDEA.
 * User: jwoo
 * Date: 2/17/14
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class CassandraClientManager implements Managed {
    private final CassandraClient client;

    public CassandraClientManager(CassandraClient client) {
        this.client = client;
    }

    @Override
    public void start() throws Exception {
        client.start();
    }

    @Override
    public void stop() throws Exception {
        client.stop();
    }
}
