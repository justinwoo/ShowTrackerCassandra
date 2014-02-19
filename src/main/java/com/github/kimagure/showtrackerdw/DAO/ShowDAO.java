package com.github.kimagure.showtrackerdw.DAO;

import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.github.kimagure.showtrackerdw.CassandraClientManager;
import com.github.kimagure.showtrackerdw.core.models.Show;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jwoo
 * Date: 2/17/14
 * Time: 8:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowDAO {

    private Session session;

    public ShowDAO(Session session) {
        this.session = session;
    }

    public Show findById(String id) {
        PreparedStatement statement = session.prepare("SELECT * FROM shows");
        return null;
    }

    public List<Show> findByTitle(String title) {
        return null;
    }

    public void persist(Show show) {
//        return null;
    }

    public List<Show> findAll() {
        ResultSet resultSet = session.execute("SELECT * FROM shows");
        List<Show> shows = new ArrayList<>();
        for(Row row : resultSet) {
            String id = row.getString("id");
            String title = row.getString("title");
            Integer episode = row.getInt("episode");
            shows.add(new Show(id, title, episode));
        }
        return shows;
    }

}
