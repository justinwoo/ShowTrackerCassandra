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

    private PreparedStatement selectByIdStatement;
    private PreparedStatement selectByTitleStatement;
    private PreparedStatement persistStatement;
    private PreparedStatement perishStatement;


    public ShowDAO(Session session) {
        this.session = session;
    }

    public Show findById(String queryId) {
        if (selectByIdStatement == null) {
            synchronized (this) {
                if (selectByIdStatement == null) {
                    selectByIdStatement = session.prepare("SELECT * FROM shows WHERE id = ?");
                }
            }
        }

        ResultSet resultSet = session.execute(selectByIdStatement.bind(queryId));
        Row row = resultSet.one();
        String id = row.getString("id");
        String title = row.getString("title");
        Integer episode = row.getInt("episode");
        return new Show(id, title, episode);
    }

    public Show findByTitle(String queryTitle) {
        if (selectByTitleStatement == null) {
            synchronized (this) {
                if (selectByTitleStatement == null) {
                    selectByTitleStatement = session.prepare("SELECT * FROM shows WHERE title = ?");
                }
            }
        }
        ResultSet resultSet = session.execute(selectByTitleStatement.bind(queryTitle));
        Row row = resultSet.one();
        String id = row.getString("id");
        String title = row.getString("title");
        Integer episode = row.getInt("episode");
        return new Show(id, title, episode);
    }

    public void persist(Show show) {
        if (persistStatement == null) {
            synchronized (this) {
                if (persistStatement == null) {
                    persistStatement = session.prepare("INSERT INTO shows (id, title, episode) VALUES (?, ?, ?)");
                }
            }
        }
        session.execute(persistStatement.bind(show.getId(), show.getTitle(), show.getEpisode()));
    }

    public void delete(String queryId) {
        if (perishStatement == null) {
            synchronized (this) {
                if (perishStatement == null) {
                    perishStatement = session.prepare("DELETE FROM shows WHERE id = ?");
                }
            }
        }
        session.execute(perishStatement.bind(queryId));
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
