package com.github.kimagure.showtrackerservice.hibernate;

import com.github.kimagure.showtrackerservice.core.Show;
import com.yammer.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/3/14
 * Time: 6:44 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
public class ShowDAO extends AbstractDAO<Show> {
    public ShowDAO(SessionFactory factory) {
        super(factory);
    }

    public Show findById(Long id) {
        return get(id);
    }

    public long create(Show show) {
        return persist(show).getId();
    }

    public List<Show> findAll() {
        return list(namedQuery("com.github.kimagure.showtrackerservice.core.Show.findAll"));
    }

}
